package com.acorp.ventimetriquadri.app.relations.branch_storage;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchStorageService {

    @Autowired
    private BranchStorageRepository branchStorageRepository;

    public List<Storage> findAllStorageByBranch(Branch branch){
        return branchStorageRepository.findAllStorageByBranch(branch);
    }

}
