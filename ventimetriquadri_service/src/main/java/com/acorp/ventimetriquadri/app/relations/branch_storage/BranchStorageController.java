package com.acorp.ventimetriquadri.app.relations.branch_storage;

import com.acorp.ventimetriquadri.app.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/app/branchstorage")
@CrossOrigin(origins = "*")
public class BranchStorageController {

    @Autowired
    private BranchStorageService branchStorageService;



}
