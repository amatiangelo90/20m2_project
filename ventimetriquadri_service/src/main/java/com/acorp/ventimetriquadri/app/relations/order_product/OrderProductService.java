package com.acorp.ventimetriquadri.app.relations.order_product;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.order.OrderEntity;
import com.acorp.ventimetriquadri.app.relations.branch_order.BranchOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private BranchOrderService branchOrderService;

    public List<OrderEntity> findAllOrderByBranch(Branch branch) {
        List<OrderEntity> orderEntities = branchOrderService.findAllOrdersByBranchId(branch.getBranchId());

        for(OrderEntity orderEntity : orderEntities){
            orderEntity.setProductList(orderProductRepository.findAllProdutsByOrderId(orderEntity));
        }
        return orderEntities;
    }
}
