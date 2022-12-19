package com.acorp.ventimetriquadri.app.supplier;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(path = "api/v1/app/suppliers")
@CrossOrigin(origins = "*")
public class SuppliersController {

    private SuppliersService suppliersService;

    @Autowired
    public SuppliersController(SuppliersService suppliersService) {
        this.suppliersService = suppliersService;
    }

    @GetMapping(path = "/findall")
    public List<Supplier> retrieveAll(){
        return suppliersService.findAll();
    }

    @GetMapping(path = "/findbyphone")
    public Supplier retrieveByPhone(@RequestParam("phone") String phone){
        return suppliersService.findByPhone(phone);
    }

    @PostMapping(path = "/save")
    public Supplier save(Supplier supplier) { return suppliersService.saveSupplier(supplier); }

    @DeleteMapping(path = "/delete")
    public void delete(Supplier supplier){
        suppliersService.delete(supplier);
    }

    @PutMapping(path = "/update")
    public void update(Supplier supplier){
        suppliersService.update(supplier);
    }

}
