package com.acorp.ventimetriquadri.app.relations.order_product;

import com.acorp.ventimetriquadri.app.order.OrderEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "OrderProduct")
@Table(name = "ORDER_PRODUCT", uniqueConstraints=
@UniqueConstraint(columnNames={"product_id", "order_entity_id"}))
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

    private String productName;
    private String unitMeasure;
    @Column(
            name = "product_id",
            updatable = false
    )
    private long productId;
    private double price;
    private double amount;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_entity_id")
    @JsonIgnore
    private OrderEntity order;


}
