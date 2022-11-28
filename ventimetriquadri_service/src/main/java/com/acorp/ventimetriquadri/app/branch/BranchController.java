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

    @Autowired
    private BranchService branchService;

    @GetMapping(path = "/findall")
    public List<Branch> retrieveAll(){
        return branchService.findAll();
    }

    @GetMapping(path = "/findByUserId")
    public List<Branch> retrieveByUserId(@RequestParam("userId") long userId){
        return branchService.findByUserId(userId);
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
