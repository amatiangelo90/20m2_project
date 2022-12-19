package com.acorp.ventimetriquadri.app.relations.order_product;

import com.acorp.ventimetriquadri.app.product.product_utils.UnitMeasure;
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
    private UnitMeasure unitMeasure;
    private long productId;
    private double price;
    private double amount;

    public static R_OrderProduct buildR_OrderProduct(OrderProduct orderProduct){
        return R_OrderProduct.builder()
                .amount(orderProduct.getAmount())
                .orderProductId(orderProduct.getOrderProductId())
                .price(orderProduct.getPrice())
                .productName(orderProduct.getProductName())
                .productId(orderProduct.getProductId())
                .build();
    }
}
