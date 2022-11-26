package com.acorp.ventimetriquadri.app.branch;

import com.acorp.ventimetriquadri.app.relations.user_branch.UserBranch;
import com.acorp.ventimetriquadri.app.relations.user_branch.UserBranchRepository;
import com.acorp.ventimetriquadri.app.relations.user_branch.UserBranchService;
import com.acorp.ventimetriquadri.app.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private UserBranchRepository userBranchRepository;

    @Autowired
    private UserBranchService userBranchService;

    @Transactional
    public void addNewBranch(Branch branch) {

        Branch branchSaved = branchRepository.save(branch);
        userBranchRepository.save(
                UserBranch.builder()
                        .userEntity(UserEntity.builder().userId(branch.getUserId()).build())
                        .branch(branchSaved).build());
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

    public List<Branch> findByUserId(long userId) {
        return userBranchService.retrieveAllBranchesByUserId(userId);
    }
}
