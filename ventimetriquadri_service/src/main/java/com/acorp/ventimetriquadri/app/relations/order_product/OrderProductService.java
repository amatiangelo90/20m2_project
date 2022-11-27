package com.acorp.ventimetriquadri.app.relations.order_product;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.order.Order;
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

    public List<Order> findAllOrderByBranch(Branch branch) {
        List<Order> orders = branchOrderService.findAllByBranchId(branch.getBranchId());

        for(Order order : orders){
            order.setProductList(orderProductRepository.findAllProdutsByOrderId(order));
        }
        return orders;
    }
}
