package com.acorp.ventimetriquadri.app.storage;

import com.acorp.ventimetriquadri.app.product.Product;
import com.acorp.ventimetriquadri.app.relations.storage_product.R_StorageProduct;
import com.acorp.ventimetriquadri.app.relations.storage_product.StorageProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Storage")
@Table(name = "STORAGE",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"storage_id", "name"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Storage {
    @Id
    @SequenceGenerator(
            name = "storage_id",
            sequenceName = "storage_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "storage_id"
    )
    @Column(
            name = "storage_id",
            updatable = false
    )
    private long storageId;
    private String name = "";
    private String creationDate = "";
    private String address= "";
    private String city = "";
    private String cap = "";

    @Transient
    private long branchId;

    @Transient
    private List<R_StorageProduct> products = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Storage)) return false;
        Storage storage = (Storage) o;
        return storageId == storage.storageId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(storageId);
    }
}
