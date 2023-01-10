package com.acorp.ventimetriquadri.app.relations.storage_product;

import com.acorp.ventimetriquadri.app.product.product_utils.UnitMeasure;
import com.acorp.ventimetriquadri.app.storage.Storage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "StorageProduct")
@Table(name = "STORAGE_PRODUCT", uniqueConstraints=
    @UniqueConstraint(columnNames={"product_id", "storage_id"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StorageProduct {

    @Id
    @SequenceGenerator(
            name = "storage_product_id",
            sequenceName = "storage_product_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "storage_product_id"
    )
    @Column(
            name = "storage_product_id",
            updatable = false
    )
    private long storageProductId;

    private String productName;
    private double stock;
    private UnitMeasure unitMeasure;
    private double amountHundred;
    private long supplierId;
    private double price;

    private boolean isAvailable;
    @Column(
            name = "product_id",
            updatable = false
    )
    private long productId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="storage_id")
    @JsonIgnore
    private Storage storage;
}
