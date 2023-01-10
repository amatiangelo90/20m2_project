package com.acorp.ventimetriquadri.app.relations.workstation_product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class R_WorkstationProduct implements Serializable {

    private long workstationProductId;
    private String productName;
    private String unitMeasure;
    private double stockFromStorage;
    private double amountLoad;
    private double amountUnload;
    private double leftOvers;
    private double price;
    private double amountHundred;
    private long productId;
    private long storageId;


    public static R_WorkstationProduct buildFromWorkstationProduct(WorkstationProduct workstationProduct) {
        return R_WorkstationProduct.builder()
                .amountHundred(workstationProduct.getAmountHundred())
                .leftOvers(workstationProduct.getLeftovers())
                .amountLoad(0.0)
                .amountUnload(0.0)
                .price(workstationProduct.getPrice())
                .productName(workstationProduct.getProductName())
                .stockFromStorage(workstationProduct.getStockFromStorage())
                .unitMeasure(workstationProduct.getUnitMeasure().name())
                .storageId(workstationProduct.getStorageId())
                .workstationProductId(workstationProduct.getWorkstationProductId())
                .productId(workstationProduct.getProductId())
                .build();
    }
}
