package com.acorp.ventimetriquadri.app.relations.user_branch;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.relations.branch_storage.BranchStorageService;
import com.acorp.ventimetriquadri.app.relations.branch_supplier.BranchSupplierService;
import com.acorp.ventimetriquadri.app.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBranchService {

    @Autowired
    private UserBranchRepository userBranchRepository;

    @Autowired
    private BranchStorageService branchStorageService;

    @Autowired
    private BranchSupplierService branchSupplierService;

    public List<Branch> retrieveAllBranchesByUserId(long userId){

        List<Branch> branches = userBranchRepository.retrieveBranchesByUserId(UserEntity.builder().userId(userId).build());

        for(Branch branch : branches){
           branch.setStorageList(branchStorageService.findAllStorageByBranch(branch));
           branch.setSupplierList(branchSupplierService.findAllSupplierByBranch(branch));
        }
        return branches;
    }
}
