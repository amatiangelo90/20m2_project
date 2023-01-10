package com.acorp.ventimetriquadri.app.branch;

import com.acorp.ventimetriquadri.app.relations.user_branch.UserPriviledge;
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
    public void save(@RequestBody Branch branch) { branchService.addNewBranch(branch); }

    @DeleteMapping(path = "/delete")
    public void delete(@RequestBody Branch branch){
        branchService.delete(branch);
    }

    @PutMapping(path = "/createbranchsupplierrelation")
    public void createBranchSupplierRelation(@RequestParam long branchId, @RequestParam long supplierId ){
        branchService.createBranchSupplierRelation(branchId, supplierId);
    }

    @PutMapping(path = "/update")
    public void update(@RequestBody Branch branch){
        branchService.update(branch);
    }

    @GetMapping(path = "/retrievebranchbyid")
    public Branch retrieveByBranchId(@RequestParam("branchid") long branchId){
        return branchService.retrieveByBranchId(branchId);
    }

    @GetMapping(path = "/retrievebranchbycode")
    public Branch retrieveByBranchCode(@RequestParam("branchcode") String branchCode){
        return branchService.retrieveByBranchCode(branchCode);
    }

    @GetMapping(path = "/linkbranchanduser")
    public void linkBranchAndUser(@RequestParam long branchId, @RequestParam long userId, @RequestParam String userPriviledge) {
        branchService.linkUserBranchId(branchId, userId, userPriviledge);
    }

    @GetMapping(path = "/retrievesuppliersbybranchid")
    public List<Supplier> retrieveAllSuppliersByBranchId(@RequestParam("branchid") long branchId){
        return branchService.retrieveSuppliersByBranchId(branchId);
    }
}
