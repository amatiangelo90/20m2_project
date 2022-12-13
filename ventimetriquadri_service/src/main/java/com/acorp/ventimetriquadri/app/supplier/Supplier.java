package com.acorp.ventimetriquadri.app.supplier;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Supplier")
@Table(name = "SUPPLIER",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"supplier_id", "email"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Supplier implements Serializable {

    @Id
    @SequenceGenerator(
            name = "supplier_id",
            sequenceName = "supplier_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "supplier_id"
    )
    @Column(
            name = "supplier_id",
            updatable = false
    )
    private long supplierId;
    @Column(
            name = "name",
            nullable = false
    )
    private String name = "";
    private String vatNumber = "";
    private String address;
    private String city;
    private String cap;
    @Column(
            name = "phone",
            unique = true,
            nullable = false
    )
    private String phoneNumber;
    private String email;
    private String pec;

    @Transient
    private long branchId;

    @Transient
    List<Product> productList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supplier)) return false;
        Supplier supplier = (Supplier) o;
        return supplierId == supplier.supplierId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId);
    }
}
