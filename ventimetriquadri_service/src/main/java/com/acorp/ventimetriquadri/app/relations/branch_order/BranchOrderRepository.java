package com.acorp.ventimetriquadri.app.relations.branch_order;

import com.acorp.ventimetriquadri.app.branch.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BranchOrderRepository extends JpaRepository<BranchOrderStorageSupplier, Long> {

    @Query(value = "SELECT brs FROM BranchOrderStorageSupplier brs WHERE brs.branch = ?1")
    Optional<List<BranchOrderStorageSupplier>> findOrdersByBranch(Branch branch);
}
