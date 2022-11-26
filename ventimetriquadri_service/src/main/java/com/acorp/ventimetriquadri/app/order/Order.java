package com.acorp.ventimetriquadri.app.order;

import com.acorp.ventimetriquadri.app.order.order_utils.OrderStatus;
import com.acorp.ventimetriquadri.app.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Order")
@Table(name = "ORDER",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"order_id"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order implements Serializable {

    @Id
    @SequenceGenerator(
            name = "order_id",
            sequenceName = "order_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_id"
    )
    @Column(
            name = "order_id",
            updatable = false
    )
    private long productId;

    private String closedBy;
    private String creationDate;
    private String deliveryDate;
    private String details;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private double total;

    @Transient
    List<Product> productList;

}
