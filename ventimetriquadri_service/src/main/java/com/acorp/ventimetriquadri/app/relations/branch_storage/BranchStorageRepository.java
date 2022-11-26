package com.acorp.ventimetriquadri.app.relations.branch_storage;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.storage.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchStorageRepository extends JpaRepository<BranchStorage, Long> {

    @Query("SELECT brst.storage FROM BranchStorage brst WHERE brst.branch = ?1")
    List<Storage> findAllStorageByBranch(Branch branch);
}
