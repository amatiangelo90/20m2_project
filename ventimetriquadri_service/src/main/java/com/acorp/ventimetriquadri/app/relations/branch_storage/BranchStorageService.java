package com.acorp.ventimetriquadri.app.relations.branch_storage;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.relations.storage_product.R_StorageProduct;
import com.acorp.ventimetriquadri.app.relations.storage_product.StorageProduct;
import com.acorp.ventimetriquadri.app.relations.storage_product.StorageProductService;
import com.acorp.ventimetriquadri.app.relations.supplier_product.SupplierProductService;
import com.acorp.ventimetriquadri.app.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.readers.operation.CachingOperationNameGenerator;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchStorageService {

    @Autowired
    private BranchStorageRepository branchStorageRepository;

    @Autowired
    private StorageProductService storageProductService;

    public List<Storage> findAllStorageByBranch(Branch branch){

        List<Storage> storages = branchStorageRepository.findAllStorageByBranch(branch);
        for(Storage storage : storages){
            List<StorageProduct> storageProducts = storageProductService.retrieveAllProductByStorage(storage);
            List<R_StorageProduct> r_storageProducts = parseStorageProductsList(storageProducts);
            storage.getProducts().addAll(r_storageProducts);
        }
        return storages;
    }

    private List<R_StorageProduct> parseStorageProductsList(List<StorageProduct> storageProducts) {

        List<R_StorageProduct> r_storageProducts = new ArrayList<>();
        for(StorageProduct storageProduct : storageProducts){
            r_storageProducts.add(R_StorageProduct.builder()
                    .amountHundred(storageProduct.getAmountHundred())
                    .isAvailable(storageProduct.isAvailable())
                    .product(storageProduct.getProduct())
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
}
