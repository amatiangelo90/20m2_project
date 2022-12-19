package com.acorp.ventimetriquadri.app.branch;

import com.acorp.ventimetriquadri.app.supplier.Supplier;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(path = "api/v1/app/branches")
@CrossOrigin(origins = "*")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping(path = "/findall")
    public List<Branch> retrieveAll(){
        return branchService.findAll();
    }

    @PostMapping(path = "/save")
    public void save(Branch branch) { branchService.addNewBranch(branch); }

    @DeleteMapping(path = "/delete")
    public void delete(Branch branch){
        branchService.delete(branch);
    }

    @PutMapping(path = "/createbranchsupplierrelation")
    public void update(@RequestParam long branchId, @RequestParam long supplierId ){
        branchService.createBranchSupplierRelation(branchId, supplierId);
    }


    @PutMapping(path = "/update")
    public void update(Branch branch){
        branchService.update(branch);
    }

    @GetMapping(path = "/retrievesuppliersbybranchid")
    public List<Supplier> retrieveAllSuppliersByBranchId(@RequestParam("branchid") long branchId){
        return branchService.retrieveSuppliersByBranchId(branchId);
    }
}
