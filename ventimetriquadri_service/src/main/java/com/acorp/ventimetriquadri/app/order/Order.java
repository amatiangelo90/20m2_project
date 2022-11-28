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
import java.util.Objects;

@Entity(name = "OrderEntity")
@Table(name = "ORDER_ENTITY",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"order_entity_id"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order implements Serializable {

    @Id
    @SequenceGenerator(
            name = "order_entity_id",
            sequenceName = "order_entity_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_entity_id"
    )
    @Column(
            name = "order_entity_id",
            updatable = false
    )
    private long orderId;
    private String orderCode;
    private String closedBy;
    private String creationDate;
    private String deliveryDate;
    private String details;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private double total;

    @Transient
    List<Product> productList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId);
    }
}
