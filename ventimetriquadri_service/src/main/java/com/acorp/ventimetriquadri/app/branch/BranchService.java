package com.acorp.ventimetriquadri.app.branch;

import com.acorp.ventimetriquadri.app.event.EventService;
import com.acorp.ventimetriquadri.app.relations.branch_supplier.BranchSupplier;
import com.acorp.ventimetriquadri.app.relations.branch_supplier.BranchSupplierRepository;
import com.acorp.ventimetriquadri.app.relations.supplier_product.SupplierProductRepository;
import com.acorp.ventimetriquadri.app.relations.user_branch.UserBranch;
import com.acorp.ventimetriquadri.app.relations.user_branch.UserBranchRepository;
import com.acorp.ventimetriquadri.app.relations.user_branch.UserPriviledge;
import com.acorp.ventimetriquadri.app.storage.StorageService;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import com.acorp.ventimetriquadri.app.user.UserEntity;
import com.acorp.ventimetriquadri.utils.Utils;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

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

    @Autowired
    private StorageService storageService;

    @Autowired
    private EventService eventService;

    @Transactional
    public UserBranch addNewBranch(Branch branch) {
        if(branch.getUserId() == 0){
            throw new IllegalArgumentException("Error - User id must be provided to link current branch to a User Entity");
        }

        Random rnd = new Random();

        int n = 10000000 + rnd.nextInt(90000000);

        logger.info("Create branch " + Utils.jsonFormat(branch) + " with unique 8 digit code: " + n);

        branch.setBranchCode(String.valueOf(n));

        Branch branchSaved = branchRepository.save(branch);
        UserBranch userBranch = UserBranch.builder()
                .userEntity(UserEntity.builder().userId(branch.getUserId()).build())
                .branch(branchSaved)
                .userPriviledge(branch.getUserPriviledge())
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
        List<Supplier> suppliers = new ArrayList<>();

        List<BranchSupplier> allSupplierByBranch = branchSupplierRepository.findAllSupplierByBranch(Branch.builder().branchId(branchId).build());

        for(BranchSupplier branchSupplier : allSupplierByBranch){
            branchSupplier.getSupplier().setBranchId(branchSupplier.getBranch().getBranchId());
            branchSupplier.getSupplier()
                    .setProductList(supplierProductRepository
                            .findAllBySupplierId(Supplier.builder().supplierId(branchSupplier.getSupplier().getSupplierId()).build()));

            suppliers.add(branchSupplier.getSupplier());
        }
        return suppliers;
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

    public Branch retrieveByBranchId(long branchId) {
        logger.info("Find branch by id [" + branchId + "]");
        Optional<Branch> branch = branchRepository.findById(branchId);
        if(branch.isPresent()){
            return enrichBranchWithStoragesSuppliersEventsOrders(branch.get());
        }else{
            throw new IllegalStateException("Errore. Non ho trovato attività con id : " + branchId);
        }

    }

    public Branch retrieveByBranchCode(String branchCode) {
        logger.info("Find branch by branch code [" + branchCode + "]");
        Optional<Branch> branch = branchRepository.findByBranchCode(branchCode);
        if(branch.isPresent()){
            return enrichBranchWithStoragesSuppliersEventsOrders(branch.get());
        }else{
            throw new IllegalStateException("Errore. Non ho trovato attività con codice : " + branchCode);
        }
    }

    Branch enrichBranchWithStoragesSuppliersEventsOrders(Branch branch){
        branch.setStorages(storageService.findAllStorageByBranch(branch));
        branch.setSuppliers(retrieveSuppliersByBranchId(branch.getBranchId()));
        branch.setEvents(eventService.findOpenEventsByBranchId(branch.getBranchId()));
//            branch.setOrderEntityList(branchOrderService.findOrdersByBranchId(branch));
        return branch;
    }

    public void linkUserBranchId(long branchId,
                                 long userId,
                                 String userPriviledge) {
        logger.info("Create relation between user with id [" + userId + "] and branch with id [" + branchId+ "] with user priviledge: " + userPriviledge);


        userBranchRepository.save(UserBranch.builder()
                .userEntity(UserEntity.builder().userId(userId).build())
                .branch(Branch.builder().branchId(branchId).build())
                .userPriviledge(UserPriviledge.valueOf(userPriviledge))
                .build());

    }
}
