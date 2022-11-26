package com.acorp.ventimetriquadri.website.controller;

import com.acorp.ventimetriquadri.website.entity.Customer;
import com.acorp.ventimetriquadri.website.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api
@RestController
@RequestMapping(path = "api/v1/website/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/findall")
    public List<Customer> retrieveAll(){
        return customerService.findAll();
    }

    @GetMapping(path = "/findallbydate")
    public List<Customer> retrieveAllByDate(@RequestParam("date") String date){
        return customerService.findAllByDate(date);
    }

    @PostMapping(path = "/save")
    public long save(Customer customer) { return customerService.addNewCustmer(customer); }

    @DeleteMapping(path = "/delete")
    public void deleteById(long customerId){
        customerService.deleteById(customerId);
    }

    @PutMapping(path = "/update")
    public void update(Customer customer){
        customerService.update(customer);
    }

    @GetMapping(path = "/findbyphone")
    public Customer retrieveByPhone(@RequestParam("phone") String phone){
        return customerService.findByPhone(phone);
    }

}
