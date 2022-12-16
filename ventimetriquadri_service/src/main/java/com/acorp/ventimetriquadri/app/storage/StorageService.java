package com.acorp.ventimetriquadri.app.storage;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.product.Product;
import com.acorp.ventimetriquadri.app.product.ProductRepository;
import com.acorp.ventimetriquadri.app.relations.branch_storage.BranchStorage;
import com.acorp.ventimetriquadri.app.relations.branch_storage.BranchStorageRepository;
import com.acorp.ventimetriquadri.app.relations.storage_product.R_StorageProduct;
import com.acorp.ventimetriquadri.app.relations.storage_product.StorageProduct;
import com.acorp.ventimetriquadri.app.relations.storage_product.StorageProductRepository;
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

    public List<Storage> findAllStorageByBranch(Branch branch){

        List<Storage> storages = branchStorageRepository.findAllStorageByBranch(branch);
        for(Storage storage : storages){
            storage.setProducts(new ArrayList<>());

            List<StorageProduct> storageProducts = retrieveAllProductByStorage(storage);
            if(!storageProducts.isEmpty()) {
                List<R_StorageProduct> r_storageProducts = parseStorageProductsList(storageProducts);
                storage.getProducts()
                        .addAll(r_storageProducts);
            }
        }
        return storages;
    }

    private List<R_StorageProduct> parseStorageProductsList(List<StorageProduct> storageProducts) {

        List<R_StorageProduct> r_storageProducts = new ArrayList<>();
        for(StorageProduct storageProduct : storageProducts){
            r_storageProducts.add(R_StorageProduct.builder()
                    .amountHundred(storageProduct.getAmountHundred())
                    .isAvailable(storageProduct.isAvailable())
                    .productName(storageProduct.getProductName())
                    .productId(storageProduct.getProductId())
                    .storageProductId(storageProduct.getStorageProductId())
                    .stock(storageProduct.getStock())
                    .stock(storageProduct.getStock())
                    .build());
        }
        return r_storageProducts;
    }

    public void save(BranchStorage branchStorage) {
        branchStorageRepository.save(branchStorage);
    }

    public void insertProductIntoStorage(long storageId, long productId) {

        if(storageId == 0){
            throw new IllegalStateException("Errore - Specidicare in quale magazzino inserire il prodotto");
        }else if(productId == 0){
            throw new IllegalStateException("Errore - Specificare il prodotto da inserire nel magazzino ");
        }else{
            Optional<Product> product = productRepository.findById(productId);
            if(product.isPresent()){
                logger.info("Insert into storage with id " + storageId + " the following product: " + Utils.jsonFormat(product.get()));
                storageProductRepository.save(StorageProduct.builder()
                        .amountHundred(0.0)
                        .isAvailable(true)
                        .stock(0.0)
                        .productId(product.get().getProductId())
                        .productName(product.get().getName())
                        .storage(Storage.builder().storageId(storageId).build())
                        .build());
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
    public void updateRStorageProduct(R_StorageProduct r_storageProduct) {
        if(r_storageProduct.getStorageProductId() == 0){
            throw new IllegalArgumentException("Error - Cannot update Product into the storage. Product Id is null or 0");
        }

        Optional<StorageProduct> storageProductById = storageProductRepository.findById(r_storageProduct.getStorageProductId());

        storageProductById.get().setAmountHundred(r_storageProduct.getAmountHundred());
        storageProductById.get().setAvailable(r_storageProduct.isAvailable());
        storageProductById.get().setStock(r_storageProduct.getStock());
    }

    public void removeProductFromStorage(long storageId, long productId) {
        storageProductRepository.delete(StorageProduct
                .builder()
                .productId(productId)
                .storage(Storage.builder().storageId(storageId).build())
                .build());
    }
}
