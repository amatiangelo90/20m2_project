package com.acorp.ventimetriquadri.app.order;

import com.acorp.ventimetriquadri.exception.CustomException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(path = "api/v1/app/order")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/send")
    public OrderEntity sendOrder(OrderEntity orderEntity) throws CustomException {
        return orderService.sendOrder(orderEntity);
    }
}
