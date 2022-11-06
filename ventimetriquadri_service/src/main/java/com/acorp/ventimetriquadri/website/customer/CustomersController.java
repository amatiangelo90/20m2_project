package com.acorp.ventimetriquadri.website.customer;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api
@RestController
@RequestMapping(path = "api/v1/website/customers")
@CrossOrigin(origins = "*")
public class CustomersController {

    private CustomersService customersService;

    @Autowired
    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping(path = "/findall")
    public List<Customers> retrieveAll(){
        return customersService.findAll();
    }

    @GetMapping(path = "/findbyphone")
    public Customers retrieveByPhone(@RequestParam("phone") String phone){
        return customersService.findByPhone(phone);
    }

    @PostMapping(path = "/save")
    public void save(Customers customers) { customersService.addNewCustmer(customers); }

    @DeleteMapping(path = "/delete")
    public void delete(Customers customers){
        customersService.delete(customers);
    }

    @PutMapping(path = "/update")
    public void update(Customers customers){
        customersService.update(customers);
    }


}
