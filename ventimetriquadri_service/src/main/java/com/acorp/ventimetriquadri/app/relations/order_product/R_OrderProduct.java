package com.acorp.ventimetriquadri.app.relations.order_product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class R_OrderProduct {

    private long orderProductId;
    private String productName;
    private String unitMeasure;
    private long productId;
    private double price;
    private double amount;

    public static R_OrderProduct buildR_OrderProduct(OrderProduct orderProduct){
        return R_OrderProduct.builder()
                .amount(orderProduct.getAmount())
                .orderProductId(orderProduct.getOrderProductId())
                .price(orderProduct.getPrice())
                .unitMeasure(orderProduct.getUnitMeasure())
                .productName(orderProduct.getProductName())
                .productId(orderProduct.getProductId())
                .build();
    }
}
