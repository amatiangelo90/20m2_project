package com.acorp.ventimetriquadri.app.storage;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.event.workstations.Workstation;
import com.acorp.ventimetriquadri.app.product.Product;
import com.acorp.ventimetriquadri.app.product.ProductRepository;
import com.acorp.ventimetriquadri.app.relations.branch_storage.BranchStorage;
import com.acorp.ventimetriquadri.app.relations.branch_storage.BranchStorageRepository;
import com.acorp.ventimetriquadri.app.relations.storage_product.R_StorageProduct;
import com.acorp.ventimetriquadri.app.relations.storage_product.StorageProduct;
import com.acorp.ventimetriquadri.app.relations.storage_product.StorageProductRepository;
import com.acorp.ventimetriquadri.app.relations.workstation_product.WorkstationProduct;
import com.acorp.ventimetriquadri.app.relations.workstation_product.WorkstationProductRepository;
import com.acorp.ventimetriquadri.app.storage.utils_model.LoadUnloadModel;
import com.acorp.ventimetriquadri.utils.Utils;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.acorp.ventimetriquadri.app.relations.storage_product.R_StorageProduct.r_storageProductFromStorageProd;

@Service
@AllArgsConstructor
public class StorageService {

    private static final Logger logger = LoggerFactory.getLogger(StorageService.class);

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private BranchStorageRepository branchStorageRepository;

    @Autowired
    private StorageProductRepository storageProductRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WorkstationProductRepository workstationProductRepository;



    public List<Storage> findAllStorageByBranch(Branch branch){

        List<Storage> storages = branchStorageRepository.findAllStorageByBranch(branch);
        for(Storage storage : storages){
            storage.setProducts(new ArrayList<>());

            List<StorageProduct> storageProducts = retrieveAllProductByStorage(storage);
            if(!storageProducts.isEmpty()) {
                List<R_StorageProduct> r_storageProducts = parseStorageProductsList(storageProducts);
                storage.getProducts().addAll(r_storageProducts);
            }
        }
        return storages;
    }

    private List<R_StorageProduct> parseStorageProductsList(List<StorageProduct> storageProducts) {
        List<R_StorageProduct> r_storageProducts = new ArrayList<>();
        for(StorageProduct storageProduct : storageProducts){
            r_storageProducts.add(r_storageProductFromStorageProd(storageProduct));
        }
        return r_storageProducts;
    }



    public void save(BranchStorage branchStorage) {
        branchStorageRepository.save(branchStorage);
    }


    public R_StorageProduct insertProductIntoStorage(long storageId, long productId) {

        if(storageId == 0){
            throw new IllegalStateException("Errore - Specidicare in quale magazzino inserire il prodotto");
        }else if(productId == 0){
            throw new IllegalStateException("Errore - Specificare il prodotto da inserire nel magazzino ");
        }else{
            Optional<Product> product = productRepository.findById(productId);
            if(product.isPresent()){
                logger.info("Insert into storage with id " + storageId + " the following product: " + Utils.jsonFormat(product.get()));
                StorageProduct save = storageProductRepository.save(StorageProduct.builder()
                        .amountHundred(0.0)
                        .isAvailable(true)
                        .stock(0.0)
                        .unitMeasure(product.get().getUnitMeasure())
                        .productId(product.get().getProductId())
                        .price(product.get().getPrice())
                        .productName(product.get().getName())
                        .supplierId(product.get().getSupplierId())
                        .storage(Storage.builder().storageId(storageId).build())
                        .build());

                return R_StorageProduct.builder()
                        .productId(save.getProductId())
                        .productName(save.getProductName())
                        .isAvailable(true)
                        .price(product.get().getPrice())
                        .storageProductId(save.getStorageProductId())
                        .unitMeasure(save.getUnitMeasure().name())
                        .stock(save.getStock())
                        .supplierId(save.getSupplierId())
                        .amountHundred(save.getAmountHundred()).build();

            }else{
                throw new IllegalStateException("Errore - Non ho trovato prodotti con id [" + productId +"] da inserire nel magazzino");
            }

        }
    }

    public List<StorageProduct> retrieveAllProductByStorage(Storage storage) {
        return storageProductRepository.retrieveProductsByStorage(storage);
    }

    @Transactional
    public Storage saveStorage(Storage storage) {

        storage.setCreationDate(Utils.globalDTFormat.format(new Date()));
        Storage storageSaved = storageRepository.save(storage);

        branchStorageRepository.save(BranchStorage.builder()
                .storage(storageSaved)
                .branch(Branch.builder().branchId(storage.getBranchId()).build()).build());

        return storageSaved;
    }

    public void delete(Storage userEntity){
        storageRepository.deleteById(userEntity.getStorageId());
    }

    public List<Storage> findAll() {
        return storageRepository.findAll();
    }

    @Transactional
    public void update(Storage storage) {
        Optional<Storage> updatingUser = storageRepository.findById(storage.getStorageId());

        if(!updatingUser.isPresent()){
            throw new IllegalStateException("Errore. Non ho trovato utenti da aggiornare");

        }else{

            if(updatingUser.get().getName() != storage.getName())
                updatingUser.get().setName(storage.getName());

            if(updatingUser.get().getAddress() != storage.getAddress())
                updatingUser.get().setAddress(storage.getAddress());

            if(updatingUser.get().getCap() != storage.getCap())
                updatingUser.get().setCap(storage.getCap());

            if(updatingUser.get().getCity() != storage.getCity())
                updatingUser.get().setCity(storage.getCity());

        }
    }

    public List<Storage> findStoragesByBranchId(long branchid) {
        return branchStorageRepository.findAllStorageByBranch(Branch.builder().branchId(branchid).build());
    }


    @Transactional
    public void addStockAmountToStorageProduct(long storageProductId, double amountToAdd) {
        if(storageProductId == 0){
            throw new IllegalArgumentException("Error - Cannot update Product into the storage. Product Id is NULL or 0");
        }
        Optional<StorageProduct> storageProductById = storageProductRepository.findById(storageProductId);
        storageProductById.get().setStock(storageProductById.get().getStock() + amountToAdd);
    }

    @Transactional
    public void removeStockAmountFromStorageProduct(long storageProductId, double amountToRemove) {
        if(storageProductId == 0){
            throw new IllegalArgumentException("Error - Cannot update Product into the storage. Product Id is NULL or 0");
        }
        Optional<StorageProduct> storageProductById = storageProductRepository.findById(storageProductId);
        storageProductById.get().setStock(storageProductById.get().getStock() - amountToRemove);
    }


    @Transactional
    public void removeProductFromStorage(long storageId, long productId) {
        logger.info("Remove product from storage. Storage id [" + storageId+"] - Product Id [" + productId+ "]");
        storageProductRepository.deleteProdFromStorageByIds(Storage.builder().storageId(storageId).build(), productId);
    }

    public Optional<Storage> findStorageByStorageId(long storageId) {
        return storageRepository.findById(storageId);
    }

    @Transactional
    public void emptystorage(long storageId) {
        logger.info("Empty storage with id --> " + storageId);
        storageProductRepository.emptyStorage(Storage.builder().storageId(storageId).build());

    }

    @Transactional
    public void setstockzerotonegativeproducts(long storageId) {
        logger.info("Set to 0 all product which have negative stock amount in storage with id --> " + storageId);
        storageProductRepository.setstockzerotonegativeproducts(Storage.builder().storageId(storageId).build());
    }

    @Transactional
    public void loadAmountOnStorage(List<LoadUnloadModel> loadUnloadModel) {

        for(LoadUnloadModel loadUnloadModelItem : loadUnloadModel){
            Optional<StorageProduct> storageProduct = storageProductRepository.retrieveProductsByStorageAndProductId(
                    Storage.builder().storageId(loadUnloadModelItem.getStorageId()).build(),
                    loadUnloadModelItem.getProductId());
            if(storageProduct.isPresent()){
                storageProduct.get().setStock(storageProduct.get().getStock() + loadUnloadModelItem.getAmount());
            }
        }

    }

    @Transactional
    public void unloadAmountOnStorage(List<LoadUnloadModel> loadUnloadModel) {

        for(LoadUnloadModel loadUnloadModelItem : loadUnloadModel){
            Optional<StorageProduct> storageProduct = storageProductRepository.retrieveProductsByStorageAndProductId(
                    Storage.builder().storageId(loadUnloadModelItem.getStorageId()).build(),
                    loadUnloadModelItem.getProductId());
            if(storageProduct.isPresent()){
                storageProduct.get().setStock(storageProduct.get().getStock() - loadUnloadModelItem.getAmount());
            }
        }

    }

    @Transactional
    public void updateAmountHundredValue(long storageProductId, double qHundredAmount) {
        Optional<StorageProduct> storageProduct = storageProductRepository.findById(storageProductId);
        if(storageProduct.isPresent()){
            storageProduct.get().setAmountHundred(qHundredAmount);

            workstationProductRepository.updateAmountHundredByProductId(qHundredAmount, storageProduct.get().getProductId());

        }else{
            throw new IllegalStateException("Errore. Non ho trovato prodotti su cui configurare q/100");
        }
    }
}
