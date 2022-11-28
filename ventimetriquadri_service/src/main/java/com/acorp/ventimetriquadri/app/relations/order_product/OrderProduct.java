package com.acorp.ventimetriquadri.app.relations.order_product;

import com.acorp.ventimetriquadri.app.order.OrderEntity;
import com.acorp.ventimetriquadri.app.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "OrderProduct")
@Table(name = "ORDER_PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderProduct {


    @Id
    @SequenceGenerator(
            name = "order_product_id",
            sequenceName = "order_product_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_product_id"
    )
    @Column(
            name = "order_product_id",
            updatable = false
    )
    private long orderProductId;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_entity_id")
    private OrderEntity orderEntity;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

    private double productAmount;

}
