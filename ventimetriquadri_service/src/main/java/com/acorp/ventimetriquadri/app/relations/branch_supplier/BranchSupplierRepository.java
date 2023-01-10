package com.acorp.ventimetriquadri.app.relations.branch_supplier;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchSupplierRepository extends JpaRepository<BranchSupplier, Long> {

    @Query("SELECT brsu FROM BranchSupplier brsu WHERE brsu.branch = ?1")
    List<BranchSupplier> findAllSupplierByBranch(Branch branch);

    @Query(value = "DELETE FROM BranchSupplier bs WHERE bs.supplier = ?1 AND bs.branch = ?2")
    @Modifying
    void deleteRelationBySupplierIdAndBranchId(Supplier supplierId, Branch branchId);
}
