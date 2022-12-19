package com.acorp.ventimetriquadri.app.relations.branch_event;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.event.Event;
import com.acorp.ventimetriquadri.app.storage.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchEventStorageRepository extends JpaRepository<BranchEventStorage, Long> {


    @Query("SELECT bes FROM BranchEventStorage bes WHERE bes.branch = ?1")
    List<BranchEventStorage> findByBranchId(Branch branch);

    @Query("SELECT bes FROM BranchEventStorage bes WHERE bes.event = ?1")
    List<BranchEventStorage> findByEventId(Event event);

    @Query("SELECT bes FROM BranchEventStorage bes WHERE bes.storage = ?1")
    List<BranchEventStorage> findByStorageId(Storage storage);

    @Modifying
    @Query("DELETE FROM BranchEventStorage bes WHERE bes.event = ?1")
    void deleteByEvent(Event event);
}
