package com.acorp.ventimetriquadri.app.product;

import com.acorp.ventimetriquadri.app.product.product_utils.UnitMeasure;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Product")
@Table(name = "PRODUCT",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"product_id", "name", "supplierId"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product implements Serializable {

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
    private String code = "";

    @Enumerated(EnumType.STRING)
    @Column(
            name = "unitMeasure",
            nullable = false
    )
    private UnitMeasure unitMeasure;

    private String unitMeasureOTH;
    private int vatApplied = 0;
    private double price = 0;
    private String description = "";
    private String category = "";

    private long supplierId;

}
