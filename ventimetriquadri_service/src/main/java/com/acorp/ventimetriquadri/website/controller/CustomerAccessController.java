package com.acorp.ventimetriquadri.website.controller;

import com.acorp.ventimetriquadri.website.entity.Customer;
import com.acorp.ventimetriquadri.website.entity.CustomerAccess;
import com.acorp.ventimetriquadri.website.service.CustomerAccessService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(path = "api/v1/website/customeraccess")
@CrossOrigin(origins = "*")
public class CustomerAccessController {


    private CustomerAccessService customerAccessService;

    @Autowired
    public CustomerAccessController(CustomerAccessService customerAccessService) {
        this.customerAccessService = customerAccessService;
    }

    @GetMapping(path = "/findall")
    public List<CustomerAccess> retrieveAll(){
        return customerAccessService.findAll();
    }

    @GetMapping(path = "/findbycustomerid")
    public List<CustomerAccess> retrieveByCustomerId(@RequestParam long customerId){
        return customerAccessService.findByCustomerId(customerId);
    }

    @PostMapping(path = "/save")
    public void save(CustomerAccess customer) { customerAccessService.addNewCustAccess(customer); }

    @DeleteMapping(path = "/delete")
    public void deleteById(long customerId){
        customerAccessService.deleteById(customerId);
    }

}
