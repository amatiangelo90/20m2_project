package com.acorp.ventimetriquadri.app.relations.branch_order;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchOrderRepository extends JpaRepository<BranchOrder, Long> {

    @Query("SELECT bo FROM BranchOrder bo WHERE bo.branch = ?1")
    List<BranchOrder> findAllByBranchId(Branch branch);
}
