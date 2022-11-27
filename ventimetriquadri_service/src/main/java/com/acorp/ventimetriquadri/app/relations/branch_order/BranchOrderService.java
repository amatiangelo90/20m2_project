package com.acorp.ventimetriquadri.app.relations.branch_order;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchOrderService {

    @Autowired
    private BranchOrderRepository branchOrderRepository;


    public List<Order> findAllByBranchId(long branchId) {
        return branchOrderRepository.findAllByBranchId(Branch.builder().branchId(branchId).build());
    }
}
