package com.acorp.ventimetriquadri.app.branch;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api
@RestController
@RequestMapping(path = "api/v1/app/branches")
@CrossOrigin(origins = "*")
public class BranchController {

    private BranchService branchService;

    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping(path = "/findall")
    public List<Branch> retrieveAll(){
        return branchService.findAll();
    }

    @GetMapping(path = "/findbyphone")
    public Branch retrieveByPhone(@RequestParam("phone") String phone){
        return branchService.findByPhone(phone);
    }

    @PostMapping(path = "/save")
    public void save(Branch branch) { branchService.addNewBranch(branch); }

    @DeleteMapping(path = "/delete")
    public void delete(Branch branch){
        branchService.delete(branch);
    }

    @PutMapping(path = "/update")
    public void update(Branch branch){
        branchService.update(branch);
    }
}
