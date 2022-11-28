package com.acorp.ventimetriquadri.app.relations.user_branch;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.relations.branch_storage.BranchStorageService;
import com.acorp.ventimetriquadri.app.relations.branch_supplier.BranchSupplierService;
import com.acorp.ventimetriquadri.app.relations.order_product.OrderProductService;
import com.acorp.ventimetriquadri.app.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBranchService {

    @Autowired
    private UserBranchRepository userBranchRepository;

    @Autowired
    private BranchStorageService branchStorageService;

    @Autowired
    private BranchSupplierService branchSupplierService;

    @Autowired
    private OrderProductService orderProductService;

    public List<Branch> retrieveAllBranchesByUserId(long userId){

        List<UserBranch> userBranches = userBranchRepository.retrieveBranchesByUserId(UserEntity.builder().userId(userId).build());

        List<Branch> branches = new ArrayList<>();

        for (UserBranch ub : userBranches){
            ub.getBranch().setToken(ub.getToken());
            branches.add(ub.getBranch());
        }

        for(Branch branch : branches){
            branch.setStorageList(branchStorageService.findAllStorageByBranch(branch));
            branch.setSupplierList(branchSupplierService.findAllSupplierByBranch(branch));
//            branch.setOrderEntityList(branchOrderService.findOrdersByBranchId(branch));
//           branch.setBranchEvent(branchEventStorageService.findEventsByBranchId(branch));
        }
        return branches;
    }
}
