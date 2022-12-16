package com.acorp.ventimetriquadri.app.branch;

import com.acorp.ventimetriquadri.app.relations.branch_supplier.BranchSupplierService;
import com.acorp.ventimetriquadri.app.relations.supplier_product.SupplierProductRepository;
import com.acorp.ventimetriquadri.app.relations.user_branch.UserBranch;
import com.acorp.ventimetriquadri.app.relations.user_branch.UserBranchRepository;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import com.acorp.ventimetriquadri.app.user.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.BinaryRefAddr;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private UserBranchRepository userBranchRepository;

    @Autowired
    private BranchSupplierService branchSupplierService;

    @Autowired
    private SupplierProductRepository supplierProductRepository;

    @Transactional
    public UserBranch addNewBranch(Branch branch) {
        if(branch.getUserId() == 0){
            throw new IllegalArgumentException("Error - User id must be provided to link current branch to a User Entity");
        }


        Branch branchSaved = branchRepository.save(branch);
        UserBranch userBranch = UserBranch.builder()
                .userEntity(UserEntity.builder().userId(branch.getUserId()).build())
                .branch(branchSaved)
                .token(branch.getToken())
                .build();

        return userBranchRepository.save(userBranch);
    }

    public void delete(Branch branch){
        branchRepository.deleteById(branch.getBranchId());
    }

    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    @Transactional
    public void update(Branch branch) {
        Optional<Branch> updatingBranch = branchRepository.findById(branch.getBranchId());

        if(!updatingBranch.isPresent()){
            throw new IllegalStateException("Errore. Non ho trovato attività da aggiornare");

        }else{

            if(updatingBranch.get().getName() != branch.getName())
                updatingBranch.get().setName(branch.getName());

            if(updatingBranch.get().getEmail() != branch.getEmail())
                updatingBranch.get().setEmail(branch.getEmail());

            if(updatingBranch.get().getPhoneNumber() != branch.getPhoneNumber())
                updatingBranch.get().setPhoneNumber(branch.getPhoneNumber());

            if(updatingBranch.get().getCity() != branch.getCity())
                updatingBranch.get().setCity(branch.getCity());

            if(updatingBranch.get().getAddress() != branch.getAddress())
                updatingBranch.get().setAddress(branch.getAddress());

            if(updatingBranch.get().getCap() != branch.getCap())
                updatingBranch.get().setCap(branch.getCap());

            if(updatingBranch.get().getVatNumber() != branch.getVatNumber())
                updatingBranch.get().setVatNumber(branch.getVatNumber());

        }
    }

    public List<Supplier> retrieveSuppliersByBranchId(long branchId){
        List<Supplier> allSupplierByBranch = branchSupplierService.findAllSupplierByBranch(Branch.builder().branchId(branchId).build());

        for(Supplier supplier : allSupplierByBranch){
            supplier.setProductList(supplierProductRepository.findAllBySupplierId(Supplier.builder().supplierId(supplier.getSupplierId()).build()));
        }

        return allSupplierByBranch;
    }
}
