package com.acorp.ventimetriquadri.app.product;

import com.acorp.ventimetriquadri.app.product.product_utils.UnitMeasure;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Product")
@Table(name = "PRODUCT",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"product_id", "name"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_id",
            sequenceName = "product_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_id"
    )
    @Column(
            name = "product_id",
            updatable = false
    )
    private long productId;
    private String name = "";
    @Enumerated(EnumType.STRING)
    private UnitMeasure unitMeasure;
    private int vatApplied = 0;
    private double price = 0;
    private String description = "";
    private String category = "";

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="supplier_id")
    private Supplier supplier;
}
