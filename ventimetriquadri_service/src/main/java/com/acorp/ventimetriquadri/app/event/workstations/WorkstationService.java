package com.acorp.ventimetriquadri.app.event.workstations;

import com.acorp.ventimetriquadri.app.product.Product;
import com.acorp.ventimetriquadri.app.product.ProductRepository;
import com.acorp.ventimetriquadri.app.relations.event_workstation.EventWorkstationRepository;
import com.acorp.ventimetriquadri.app.relations.storage_product.R_StorageProduct;
import com.acorp.ventimetriquadri.app.relations.storage_product.StorageProduct;
import com.acorp.ventimetriquadri.app.relations.storage_product.StorageProductRepository;
import com.acorp.ventimetriquadri.app.relations.workstation_product.R_WorkstationProduct;
import com.acorp.ventimetriquadri.app.relations.workstation_product.WorkstationProduct;
import com.acorp.ventimetriquadri.app.relations.workstation_product.WorkstationProductRepository;
import com.acorp.ventimetriquadri.app.storage.Storage;
import com.acorp.ventimetriquadri.app.storage.StorageService;
import com.acorp.ventimetriquadri.utils.Utils;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.acorp.ventimetriquadri.app.relations.workstation_product.R_WorkstationProduct.buildFromWorkstationProduct;
import static java.lang.Thread.sleep;

@Service
@AllArgsConstructor
public class WorkstationService {

    private static final Logger logger = LoggerFactory.getLogger(WorkstationService.class);

    @Autowired
    private WorkstationRepository workstationRepository;

    @Autowired
    private WorkstationProductRepository workstationProductRepository;

    @Autowired
    private StorageProductRepository storageProductRepository;

    @Autowired
    private EventWorkstationRepository eventWorkstationRepository;

    @Autowired
    private StorageService storageService;

    @Autowired
    private ProductRepository productRepository;


    public R_WorkstationProduct insertProductIntoWorkstation(long workstationId, long productId, long storageId) {

        if(workstationId == 0){
            throw new IllegalStateException("Errore - Specidicare in quale workstation inserire il prodotto");
        }else if(productId == 0){
            throw new IllegalStateException("Errore - Specificare il prodotto da inserire nel magazzino ");
        }else{

            Optional<StorageProduct> product = storageProductRepository
                    .retrieveProductsByStorageAndProductId(Storage.builder().storageId(storageId).build(), productId);

            if(product.isPresent()){
                logger.info("Insert into workstation with id " + workstationId + " the following product: " + Utils.jsonFormat(product.get()));
                WorkstationProduct save = workstationProductRepository.save(WorkstationProduct.builder()
                        .amountHundred(product.get().getAmountHundred())
                        .leftovers(0.0)
                        .amountLoad(0.0)
                        .amountUnload(0.0)
                        .price(product.get().getPrice())
                        .unitMeasure(product.get().getUnitMeasure())
                        .stockFromStorage(0.0)
                        .storageId(storageId)
                        .productId(product.get().getProductId())
                        .productName(product.get().getProductName())
                        .workstation(Workstation.builder().workstationId(workstationId).build())
                        .build());

                return R_WorkstationProduct.buildFromWorkstationProduct(save);

            }else{
                throw new IllegalStateException("Errore - Non ho trovato prodotti con id [" + productId +"] da inserire nella workstation");
            }
        }
    }

    public List<R_WorkstationProduct> retrieveAllProductByWorkstationId(long workstationId) {

        logger.info("Retrieve all product related with workstation with id " + workstationId);
        List<WorkstationProduct> workstationProducts = workstationProductRepository.findProductsAvailableByWorkstation(Workstation.builder().workstationId(workstationId).build());

        if(!workstationProducts.isEmpty()){
            return refatorToR_WorkstationProductCurrentWorkstationProductList(workstationProducts);
        }

        return new ArrayList<>();
    }

    private List<R_WorkstationProduct> refatorToR_WorkstationProductCurrentWorkstationProductList(List<WorkstationProduct> workstationProducts) {
        List<R_WorkstationProduct> r_workstationProducts = new ArrayList<>();
        for(WorkstationProduct workstationProduct : workstationProducts){
            r_workstationProducts.add(buildFromWorkstationProduct(workstationProduct));
        }

        return r_workstationProducts;
    }

    @Transactional
    public void removeProductFromWorkstation(long workstationProductId) {
        Optional<WorkstationProduct> workstationProductOpt = workstationProductRepository.findById(workstationProductId);
        if(workstationProductOpt.isPresent()){

            logger.info("Cancellazione del prodotto (" + workstationProductOpt.get().getProductName() +") " +
                            "con id [" + workstationProductId + "] dalla workstation (" + workstationProductOpt.get().getWorkstation().getName() + ") con id [ "
                            + workstationProductOpt.get().getWorkstation().getWorkstationId() +"]");

            long storageId = workstationProductOpt.get().getStorageId();
            long productId = workstationProductOpt.get().getProductId();

            Optional<StorageProduct> storageProductByProdIdAndStorage = storageProductRepository.retrieveProductsByStorageAndProductId(Storage.builder().storageId(storageId).build(), productId);
            storageProductByProdIdAndStorage.get().setStock(storageProductByProdIdAndStorage.get().getStock() + workstationProductOpt.get().getStockFromStorage());

            workstationProductRepository.deleteById(workstationProductId);
        }
    }

    @Transactional
    public void reloadNotConsumedAmountOfworkstationIntoReferredStorage(long workstationProductId) {
        Optional<WorkstationProduct> workstationProductOpt = workstationProductRepository.findById(workstationProductId);
        if(workstationProductOpt.isPresent()){

            logger.info("Reinserisco la giacenza del prodotto prodotto (" + workstationProductOpt.get().getProductName() +") " +
                    "con id [" + workstationProductId + "] dalla workstation (" + workstationProductOpt.get().getWorkstation().getName() + ") con id [ "
                    + workstationProductOpt.get().getWorkstation().getWorkstationId() +"] nel magazzino di riferimento");

            long storageId = workstationProductOpt.get().getStorageId();
            long productId = workstationProductOpt.get().getProductId();

            Optional<StorageProduct> storageProductByProdIdAndStorage = storageProductRepository
                    .retrieveProductsByStorageAndProductId(Storage.builder().storageId(storageId).build(), productId);
            storageProductByProdIdAndStorage.get().setStock(storageProductByProdIdAndStorage.get().getStock() + (workstationProductOpt.get().getLeftovers()));
        }
    }

    @Transactional
    public void set0ToProductWorkstationStockFromStorageValue(long workstationProductId) {
        Optional<WorkstationProduct> workstationProductOpt = workstationProductRepository.findById(workstationProductId);

        if(workstationProductOpt.isPresent()){

            logger.info("Reset del valore 'loadFromWorkstation' a 0 del prodotto (" + workstationProductOpt.get().getProductName() +") " +
                    "con id [" + workstationProductId + "] dalla workstation (" + workstationProductOpt.get().getWorkstation().getName() + ") con id [ "
                    + workstationProductOpt.get().getWorkstation().getWorkstationId() +"]");

            long storageId = workstationProductOpt.get().getStorageId();
            long productId = workstationProductOpt.get().getProductId();

            Optional<StorageProduct> storageProductByProdIdAndStorage
                    = storageProductRepository.retrieveProductsByStorageAndProductId(Storage.builder().storageId(storageId).build(), productId);
            if(storageProductByProdIdAndStorage.isPresent()){
                storageProductByProdIdAndStorage.get().setStock(storageProductByProdIdAndStorage.get().getStock() + workstationProductOpt.get().getStockFromStorage());
                workstationProductOpt.get().setStockFromStorage(0);
            }else{
                Optional<Product> productById = productRepository.findById(productId);

                storageProductRepository.save(StorageProduct.builder()
                        .price(productById.get().getPrice())
                        .supplierId(productById.get().getSupplierId())
                        .unitMeasure(productById.get().getUnitMeasure())
                        .productName(productById.get().getName())
                        .productId(productById.get().getProductId())
                        .stock(workstationProductOpt.get().getStockFromStorage())
                        .build());

                workstationProductOpt.get().setStockFromStorage(0);

            }

        }else{
            throw new IllegalArgumentException("Error - Non ho trovato il prodotto corrispondente nella workstation con id " + workstationProductId);
        }
    }

    @Transactional
    public void workstationProduct_updateStockValue(long workstationProdId, double stockValue) {
        if(workstationProdId == 0){
            throw new IllegalArgumentException("Error - Cannot update Product into the storage. Product Id is null or 0");
        }
        Optional<WorkstationProduct> workstationProduct = workstationProductRepository.findById(workstationProdId);

        Optional<StorageProduct> storageProduct = storageProductRepository.retrieveProductsByStorageAndProductId(
                Storage.builder().storageId(workstationProduct.get().getStorageId()).build(),
                workstationProduct.get().getProductId());


        if(storageProduct.isPresent() && workstationProduct.isPresent()){
            workstationProduct.get().setStockFromStorage(workstationProduct.get().getStockFromStorage() + stockValue);
            storageProduct.get().setStock(storageProduct.get().getStock() - stockValue);

        }
    }

    @Transactional
    public void workstationProduct_updateConsumedValue(long r_storageProductId, double consumed) {
        if(r_storageProductId == 0){
            throw new IllegalArgumentException("Error - Cannot update Product into the storage. Product Id is null or 0");
        }
        Optional<WorkstationProduct> workstationProduct = workstationProductRepository.findById(r_storageProductId);

        if(workstationProduct.isPresent()){
            workstationProduct.get().setLeftovers(workstationProduct.get().getLeftovers() + consumed);
        }
    }

    @Transactional
    public void removeWorkstation(long workstationId){
        logger.info("Cancellazione della workstation con id " + workstationId + " in corso..");
        Workstation workstationToDelete = findByWorkstationId(workstationId);

        for(R_WorkstationProduct r_workstationProduct : workstationToDelete.getProducts()){
            removeProductFromWorkstation(r_workstationProduct.getWorkstationProductId());
        }
        eventWorkstationRepository.removeByWorkstationId(Workstation.builder().workstationId(workstationToDelete.getWorkstationId()).build());
        workstationRepository.deleteById(workstationToDelete.getWorkstationId());
        logger.info("Workstation con id " + workstationId + " elimninata.");

    }

    public Workstation findByWorkstationId(long workstationId){
        if(workstationId == 0){
            throw new IllegalArgumentException("Error - Cannot delete workstation. Workstation Id is null or 0");
        }

        Optional<Workstation> workstation = workstationRepository.findById(workstationId);

        if(workstation.isPresent()){
            workstation.get().setProducts(retrieveAllProductByWorkstationId(workstationId));
        }

        return workstation.get();
    }

    public Workstation createWorkstation(Workstation workstation) {
        return workstationRepository.save(workstation);
    }


    @Transactional
    public Workstation updateWorkstation(Workstation workstation) {
        logger.info("Aggiornamento della workstation " + workstation.toString() + " in corso..");

        Optional<Workstation> workstationRetr = workstationRepository.findById(workstation.getWorkstationId());

        if(workstationRetr.isPresent()){
            if(workstationRetr.get().getName() != workstation.getName()){
                workstationRetr.get().setName(workstation.getName());
            }
            if(workstationRetr.get().getResponsable() != workstation.getResponsable()){
                workstationRetr.get().setResponsable(workstation.getResponsable());
            }

            return workstationRetr.get();
        }else{
            throw new IllegalArgumentException("Errore - Nessuna workstation trovata con il seguente id" + workstation.getWorkstationId());
        }
    }

    @Transactional
    public void performLoadWorkstation(List<WorkstationLoadUnloadProduct> workstationLoadUnloadProductList) {

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(WorkstationLoadUnloadProduct wlup : workstationLoadUnloadProductList){
            Optional<WorkstationProduct> workstationProductById = workstationProductRepository.findById(wlup.getWorkstationProductId());

            if(workstationProductById.isPresent()){

                if(wlup.getStorageProductId() == 0){
                    R_StorageProduct r_storageProduct = storageService.insertProductIntoStorage(wlup.getStorageId(), wlup.getProductId());
                    storageService.removeStockAmountFromStorageProduct(r_storageProduct.getStorageProductId(), wlup.getAmount());
                    workstationProductById.get().setStockFromStorage(workstationProductById.get().getStockFromStorage() + wlup.getAmount());
                }else{
                    storageService.removeStockAmountFromStorageProduct(wlup.getStorageProductId(), wlup.getAmount());
                    workstationProductById.get().setStockFromStorage(workstationProductById.get().getStockFromStorage() + wlup.getAmount());
                }

            }
        }
    }

    @Transactional
    public void performUnloadWorkstation(List<WorkstationLoadUnloadProduct> workstationLoadUnloadProductList) {

        try {
            sleep(1400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(WorkstationLoadUnloadProduct wlup : workstationLoadUnloadProductList){
            Optional<WorkstationProduct> workstationProductById = workstationProductRepository.findById(wlup.getWorkstationProductId());

            if(workstationProductById.isPresent()){
                workstationProductById.get().setLeftovers(workstationProductById.get().getLeftovers() + wlup.getAmount());
            }
        }

    }

    @Transactional
    public void deleteProductFromWorkstation(long workstationProductId) {
        logger.info("Rimozione del prodotto con id " + workstationProductId + " in corso..");
        Optional<WorkstationProduct> workstationProdById = workstationProductRepository.findById(workstationProductId);

        if(workstationProdById.isPresent()){

            Optional<StorageProduct> storageProduct = storageProductRepository.retrieveProductsByStorageAndProductId(
                    Storage.builder().storageId(workstationProdById.get().getStorageId()).build(),
                    workstationProdById.get().getProductId());

            if(storageProduct.isPresent()){
                storageProduct.get().setStock(storageProduct.get().getStock() + workstationProdById.get().getStockFromStorage());
                workstationProductRepository.deleteById(workstationProductId);
            }else{
                throw new IllegalArgumentException("Errore - Non ho trovato nessun magazzino con id " + workstationProdById.get().getStorageId() + ". Contattare l'assistenza" );
            }


        }else{
            throw new IllegalArgumentException("Errore - Non ho trovato nessun prodotto con id " + workstationProductId + " nella tabella WORKSTATION_PRODUCT" );
        }
    }

    @Transactional
    public void set0ToConsumedProductWorkstation(long workstationProductId) {
        logger.info("Set 0 to leftOvers amount to product with id " + workstationProductId + " ..");
        workstationProductRepository.updateLeftOversValue(0, workstationProductId);
    }
}
