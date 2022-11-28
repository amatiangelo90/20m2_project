package com.acorp.ventimetriquadri.app.relations.branch_order;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.order.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchOrderService {

    @Autowired
    private BranchOrderRepository branchOrderRepository;


    public List<OrderEntity> findAllOrdersByBranchId(long branchId) {
        List<BranchOrder> branchOrders = branchOrderRepository.findAllByBranchId(Branch.builder().branchId(branchId).build());
        List<OrderEntity> orderEntities = new ArrayList<>();
        for(BranchOrder branchOrder : branchOrders){
            orderEntities.add(branchOrder.getOrderEntity());
        }
        return orderEntities;
    }
}
