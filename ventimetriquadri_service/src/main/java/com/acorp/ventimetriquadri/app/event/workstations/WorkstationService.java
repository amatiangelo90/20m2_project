package com.acorp.ventimetriquadri.app.event.workstations;

import com.acorp.ventimetriquadri.app.product.ProductRepository;
import com.acorp.ventimetriquadri.app.relations.event_workstation.EventWorkstationRepository;
import com.acorp.ventimetriquadri.app.relations.storage_product.StorageProduct;
import com.acorp.ventimetriquadri.app.relations.storage_product.StorageProductRepository;
import com.acorp.ventimetriquadri.app.relations.workstation_product.R_WorkstationProduct;
import com.acorp.ventimetriquadri.app.relations.workstation_product.WorkstationProduct;
import com.acorp.ventimetriquadri.app.relations.workstation_product.WorkstationProductRepository;
import com.acorp.ventimetriquadri.app.storage.Storage;
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

    public void insertProductIntoWorkstation(long workstationId, long productId, long storageId) {

        if(workstationId == 0){
            throw new IllegalStateException("Errore - Specidicare in quale workstation inserire il prodotto");
        }else if(productId == 0){
            throw new IllegalStateException("Errore - Specificare il prodotto da inserire nel magazzino ");
        }else{

            Optional<StorageProduct> product = storageProductRepository.retrieveProductsByStorageAndProductId(Storage.builder().storageId(storageId).build(), productId);

            if(product.isPresent()){
                logger.info("Insert into workstation with id " + workstationId + " the following product: " + Utils.jsonFormat(product.get()));
                workstationProductRepository.save(WorkstationProduct.builder()
                        .amountHundred(product.get().getAmountHundred())
                        .consumed(0.0)
                        .unitMeasure(product.get().getUnitMeasure())
                        .stockFromStorage(0.0)
                        .storageId(storageId)
                        .productId(product.get().getProductId())
                        .productName(product.get().getProductName())
                        .workstation(Workstation.builder().workstationId(workstationId).build())
                        .build());
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
            workstationProduct.get().setConsumed(workstationProduct.get().getConsumed() + consumed);
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
    }

    public Workstation findByWorkstationId(long workstationId){
        if(workstationId == 0){
            throw new IllegalArgumentException("Error - Cannot delete workstation. Workstation Id is null or 0");
        }

        Optional<Workstation> workstaiton = workstationRepository.findById(workstationId);

        if(workstaiton.isPresent()){
            workstaiton.get().setProducts(retrieveAllProductByWorkstationId(workstationId));
        }

        return workstaiton.get();
    }

    public Workstation createWorkstation(Workstation workstation) {
        return workstationRepository.save(workstation);
    }
}
