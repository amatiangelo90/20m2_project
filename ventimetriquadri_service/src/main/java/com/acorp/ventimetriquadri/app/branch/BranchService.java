package com.acorp.ventimetriquadri.app.branch;

import com.acorp.ventimetriquadri.app.event.EventService;
import com.acorp.ventimetriquadri.app.relations.branch_supplier.BranchSupplier;
import com.acorp.ventimetriquadri.app.relations.branch_supplier.BranchSupplierRepository;
import com.acorp.ventimetriquadri.app.relations.supplier_product.SupplierProductRepository;
import com.acorp.ventimetriquadri.app.relations.user_branch.UserBranch;
import com.acorp.ventimetriquadri.app.relations.user_branch.UserBranchRepository;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import com.acorp.ventimetriquadri.app.user.UserEntity;
import com.acorp.ventimetriquadri.utils.Utils;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BranchService {

    private static final Logger logger = LoggerFactory.getLogger(EventService.class);

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private UserBranchRepository userBranchRepository;

    @Autowired
    private BranchSupplierRepository branchSupplierRepository;

    @Autowired
    private SupplierProductRepository supplierProductRepository;

    @Transactional
    public UserBranch addNewBranch(Branch branch) {
        if(branch.getUserId() == 0){
            throw new IllegalArgumentException("Error - User id must be provided to link current branch to a User Entity");
        }
        logger.info("Create branch " + Utils.jsonFormat(branch));
        Branch branchSaved = branchRepository.save(branch);
        UserBranch userBranch = UserBranch.builder()
                .userEntity(UserEntity.builder().userId(branch.getUserId()).build())
                .branch(branchSaved)
                .token(branch.getToken())
                .build();

        return userBranchRepository.save(userBranch);
    }

    public void delete(Branch branch){
        logger.info("Delete branch " + Utils.jsonFormat(branch));
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
            logger.info("Update branch " + Utils.jsonFormat(branch));

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
        List<Supplier> allSupplierByBranch = branchSupplierRepository.findAllSupplierByBranch(Branch.builder().branchId(branchId).build());

        for(Supplier supplier : allSupplierByBranch){
            supplier.setProductList(supplierProductRepository.findAllBySupplierId(Supplier.builder().supplierId(supplier.getSupplierId()).build()));
        }
        return allSupplierByBranch;
    }

    @Transactional
    public void createBranchSupplierRelation(long branchId, long supplierId) {
        logger.info("Connect branch with id [" + branchId + "] with supplier with id [" + supplierId + "]");
        branchSupplierRepository.save(BranchSupplier
                .builder()
                .branch(Branch.builder().branchId(branchId).build())
                .supplier(Supplier.builder().supplierId(supplierId).build())
                .build());
    }

    public Optional<Branch> findByBranchId(long branchId) {
        return branchRepository.findById(branchId);
    }
}
