package com.acorp.ventimetriquadri.app.relations.storage_product;

import com.acorp.ventimetriquadri.app.product.Product;
import com.acorp.ventimetriquadri.app.storage.Storage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "StorageProduct")
@Table(name = "STORAGE_PRODUCT", uniqueConstraints=
    @UniqueConstraint(columnNames={"product_id", "storage_id"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
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

    private double stock;
    private double amountHundred;
    private boolean isAvailable;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="storage_id")
    private Storage storage;

}
