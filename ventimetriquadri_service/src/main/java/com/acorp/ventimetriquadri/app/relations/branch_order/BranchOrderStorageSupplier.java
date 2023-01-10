package com.acorp.ventimetriquadri.app.relations.branch_order;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.order.OrderEntity;
import com.acorp.ventimetriquadri.app.storage.Storage;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "BranchOrderStorageSupplier")
@Table(name = "BRANCH_ORDER")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BranchOrderStorageSupplier implements Serializable {

    @Id
    @SequenceGenerator(
            name = "branch_order_storage_supplier_id",
            sequenceName = "branch_order_storage_supplier_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "branch_order_storage_supplier_id"
    )
    @Column(
            name = "branch_order_storage_supplier_id",
            updatable = false
    )
    private long branchOrderStorageSupplierId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="branch_id")
    private Branch branch;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id", unique = true)
    private OrderEntity orderEntity;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="storage_id")
    private Storage storage;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="supplier_id")
    private Supplier supplier;


}
