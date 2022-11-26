package com.acorp.ventimetriquadri.app.order;

import com.acorp.ventimetriquadri.app.product.Product;
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
    public List<Order> retrieveAll(){
        return orderService.findAll();
    }

    @PostMapping(path = "/save")
    public void save(Order order) { orderService.createOrder(order); }

    @DeleteMapping(path = "/delete")
    public void delete(Order order){
        orderService.delete(order);
    }

    @PutMapping(path = "/update")
    public void update(Order order){
        orderService.update(order);
    }

}
