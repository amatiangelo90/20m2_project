package com.acorp.ventimetriquadri.app.user;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.branch.BranchService;
import com.acorp.ventimetriquadri.app.event.EventService;
import com.acorp.ventimetriquadri.app.relations.user_branch.UserBranch;
import com.acorp.ventimetriquadri.app.relations.user_branch.UserBranchRepository;
import com.acorp.ventimetriquadri.app.storage.StorageService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
//@Slf4j
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBranchRepository userBranchRepository;

    @Autowired
    private StorageService storageService;

    @Autowired
    private BranchService branchService;

    @Autowired
    private EventService eventService;


    public UserEntity addNewUser(UserEntity userEntity) {
        logger.info("Save new User : " + userEntity.toString());
        return userRepository.save(userEntity);
    }

    public void delete(UserEntity userEntity){
        userRepository.deleteById(userEntity.getUserId());
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void update(UserEntity userEntity) {
        Optional<UserEntity> updatingUser = userRepository.findById(userEntity.getUserId());

        if(!updatingUser.isPresent()){
            throw new IllegalStateException("Errore. Non ho trovato utenti da aggiornare");

        }else{

            if(updatingUser.get().getName() != userEntity.getName())
                updatingUser.get().setName(userEntity.getName());

            if(updatingUser.get().getEmail() != userEntity.getEmail())
                updatingUser.get().setEmail(userEntity.getEmail());

            if(updatingUser.get().getPhone() != userEntity.getPhone())
                updatingUser.get().setPhone(userEntity.getPhone());

        }
    }

    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<Branch> retrieveAllBranchesByUserId(long userId){

        logger.info("Retrieve all Branches for the user with Id " + userId);
        List<UserBranch> userBranches = userBranchRepository.retrieveBranchesByUserId(UserEntity.builder().userId(userId).build());

        List<Branch> branches = new ArrayList<>();

        for (UserBranch ub : userBranches){
            ub.getBranch().setToken(ub.getToken());
            branches.add(ub.getBranch());
        }

        for(Branch branch : branches){
            branch.setStorages(storageService.findAllStorageByBranch(branch));
            branch.setSuppliers(branchService.retrieveSuppliersByBranchId(branch.getBranchId()));
            branch.setEvents(eventService.findOpenEventsByBranchId(branch.getBranchId()));
//            branch.setOrderEntityList(branchOrderService.findOrdersByBranchId(branch));
//           branch.setBranchEvent(branchEventStorageService.findOpenEventsByBranchId(branch));
        }
        return branches;
    }

    public UserBranch save(UserBranch userBranch){
        return userBranchRepository.save(userBranch);
    }


}
