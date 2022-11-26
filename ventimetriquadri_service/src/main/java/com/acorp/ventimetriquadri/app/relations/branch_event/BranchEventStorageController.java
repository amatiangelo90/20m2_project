package com.acorp.ventimetriquadri.app.relations.branch_event;

import com.acorp.ventimetriquadri.app.branch.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/app/brancheventstorage")
@CrossOrigin(origins = "*")
public class BranchEventStorageController {


    @Autowired
    private BranchEventStorageService branchEventStorageService;

    @PostMapping(path = "/save")
    public void save(BranchEventStorage branchEventStorage) {
        branchEventStorageService.saveBranchEventStorageEntity(branchEventStorage);
    }

    @GetMapping(path = "/retrieveall")
    public List<BranchEventStorage> retrieveAll() {
        return branchEventStorageService.findAll();
    }

    @GetMapping(path = "/retrievebybranchid")
    public List<BranchEventStorage> retrieveByBranchId(@RequestParam long branchId) {
        return branchEventStorageService.findAllByBranchId(Branch.builder().branchId(branchId).build());
    }

}
