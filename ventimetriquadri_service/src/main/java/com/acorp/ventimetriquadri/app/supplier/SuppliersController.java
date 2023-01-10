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

    @Autowired
    private SuppliersService suppliersService;

    @GetMapping(path = "/findall")
    public List<Supplier> retrieveAll(){
        return suppliersService.findAll();
    }

    @GetMapping(path = "/findbycode")
    public Supplier retrieveSupplierByCode(@RequestParam("suppliercode") String supplierCode){
        return suppliersService.findByCode(supplierCode);
    }

    @PostMapping(path = "/save")
    public Supplier save(@RequestBody Supplier supplier) {
        return suppliersService.saveSupplier(supplier);
    }

    @DeleteMapping(path = "/delete")
    public void deleterelationsupplierbranch(@RequestParam long supplierId, @RequestParam long branchId){
        suppliersService.deleteRelationSupplierBranch(supplierId, branchId);
    }

    @PutMapping(path = "/update")
    public void update(@RequestBody Supplier supplier){
        suppliersService.update(supplier);
    }

    @GetMapping(path = "/connectbranchsupplier")
    public void update(@RequestParam long branchId, @RequestParam long supplierId){
        suppliersService.connectSupplierToBranch(branchId, supplierId);
    }
}
