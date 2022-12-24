package com.acorp.ventimetriquadri.app.relations.storage_product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class R_StorageProduct implements Serializable {

    private long storageProductId;
    private String productName;
    private String unitMeasure;
    private double stock;
    private double amountHundred;
    private boolean isAvailable;
    private long productId;

    public static R_StorageProduct r_storageProductFromStorageProd(StorageProduct storageProduct) {
        return R_StorageProduct.builder()
                .amountHundred(storageProduct.getAmountHundred())
                .isAvailable(storageProduct.isAvailable())
                .productName(storageProduct.getProductName())
                .unitMeasure(storageProduct.getUnitMeasure().name())
                .productId(storageProduct.getProductId())
                .storageProductId(storageProduct.getStorageProductId())
                .stock(storageProduct.getStock())
                .stock(storageProduct.getStock())
                .build();
    }
}
