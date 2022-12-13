package com.acorp.ventimetriquadri.app.relations.storage_product;

import com.acorp.ventimetriquadri.app.product.Product;
import com.acorp.ventimetriquadri.app.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageProductService {

    @Autowired
    private StorageProductRepository storageProductRepository;


    public void insertProductIntoStorage(long storageId, long productId) {
        if(storageId == 0){
            throw new IllegalStateException("Errore - Specidicare in quale magazzino inserire il prodotto");
        }else if(productId == 0){
            throw new IllegalStateException("Errore - Specificare il prodotto da inserire nel magazzino ");
        }else{
            storageProductRepository.save(StorageProduct.builder()
                    .amountHundred(0.0)
                    .isAvailable(true)
                    .stock(0.0)
                    .product(Product.builder().productId(productId).build())
                    .storage(Storage.builder().storageId(storageId).build())
                    .build());
        }
    }

    public List<StorageProduct> retrieveAllProductByStorage(Storage storage) {
        return storageProductRepository.retrieveProductsByStorage(storage);
    }
}
