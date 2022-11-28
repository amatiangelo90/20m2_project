package com.acorp.ventimetriquadri.app.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/app/order")
@CrossOrigin(origins = "*")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "/findall")
    public List<OrderEntity> retrieveAll(){
        return orderService.findAll();
    }

    @PostMapping(path = "/save")
    public void save(OrderEntity orderEntity) { orderService.createOrder(orderEntity); }

    @DeleteMapping(path = "/delete")
    public void delete(OrderEntity orderEntity){
        orderService.delete(orderEntity);
    }

    @PutMapping(path = "/update")
    public void update(OrderEntity orderEntity){
        orderService.update(orderEntity);
    }

}
