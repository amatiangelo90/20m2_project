package com.acorp.ventimetriquadri.app.relations.supplier_product;

import com.acorp.ventimetriquadri.app.product.Product;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "SupplierProduct")
@Table(name = "SUPPLIER_PRODUCT", uniqueConstraints=
@UniqueConstraint(columnNames={"product_id", "supplier_id"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SupplierProduct {

    @Id
    @SequenceGenerator(
            name = "supplier_product_id",
            sequenceName = "supplier_product_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "supplier_product_id"
    )
    @Column(
            name = "supplier_product_id",
            updatable = false
    )
    private long supplierProductId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="supplier_id")
    private Supplier supplier;

}
