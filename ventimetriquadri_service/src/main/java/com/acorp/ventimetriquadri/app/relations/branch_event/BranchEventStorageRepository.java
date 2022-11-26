package com.acorp.ventimetriquadri.app.relations.branch_event;

import com.acorp.ventimetriquadri.app.branch.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchEventStorageRepository extends JpaRepository<BranchEventStorage, Long> {


    @Query("SELECT bes FROM BranchEventStorage bes WHERE bes.branch = ?1")
    List<BranchEventStorage> findByBranchId(Branch branchId);
}
