package com.acorp.ventimetriquadri.app.relations.branch_storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/app/branchstorage")
@CrossOrigin(origins = "*")
public class BranchStorageController {

    @Autowired
    private BranchStorageService branchStorageService;


}
