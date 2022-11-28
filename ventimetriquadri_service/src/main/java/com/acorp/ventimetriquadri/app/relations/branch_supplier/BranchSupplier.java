package com.acorp.ventimetriquadri.app.relations.branch_supplier;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "BranchSupplier")
@Table(name = "BRANCH_SUPPLIER", uniqueConstraints=
@UniqueConstraint(columnNames={"branch_id", "supplier_id"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BranchSupplier {

    @Id
    @SequenceGenerator(
            name = "branch_supplier_id",
            sequenceName = "branch_supplier_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "branch_supplier_id"
    )
    @Column(
            name = "branch_supplier_id",
            updatable = false
    )
    private long branchSupplierId;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="branch_id")
    private Branch branch;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="supplier_id")
    private Supplier supplier;

}
