package com.acorp.ventimetriquadri.app.order;

import com.acorp.ventimetriquadri.app.order.utils.OrderStatus;
import com.acorp.ventimetriquadri.app.relations.order_product.R_OrderProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Entity(name = "OrderEntity")
@Table(name = "ORDER_ENTITY",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"order_id", "code"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderEntity {

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
    private long orderId;

    @Column(
            name = "code",
            updatable = false
    )
    private String code;
    private double total;

    @Enumerated
    private OrderStatus orderStatus;

    @Transient
    private String errorStatus;

    @Transient
    @ElementCollection
    ArrayList<R_OrderProduct> products;

    private String creationDate;
    private String senderUser;

    private String details;

    private String deliveryDate;

    private String closedBy;
    private boolean isPaid;

    @Transient
    private long supplierId;

    @Transient
    private long branchId;

    @Transient
    private long storageId;

}
