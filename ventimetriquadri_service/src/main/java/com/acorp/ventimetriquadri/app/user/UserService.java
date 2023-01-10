package com.acorp.ventimetriquadri.app.user;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.branch.BranchService;
import com.acorp.ventimetriquadri.app.event.EventService;
import com.acorp.ventimetriquadri.app.order.OrderService;
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

    @Autowired
    private OrderService orderService;


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
        if(email != null && !"".equalsIgnoreCase(email)){
            logger.info("Retrieve user by email: " + email);
            Optional<UserEntity> userOpt = userRepository.findByEmail(email);
            if(userOpt.isPresent()){
                userOpt.get().setBranchList(retrieveAllBranchesByUserId(userOpt.get().getUserId()));
            }else{
                throw new RuntimeException("Errore - Nessun utente trovato con la seguente email: " + email );
            }
            return userOpt.get();
        }else{
            throw new RuntimeException("Errore - La mail per la ricerca dell'utente risulta NULL o vuota. Inserire una mail corretta");
        }

    }

    public List<Branch> retrieveAllBranchesByUserId(long userId){

        logger.info("Retrieve all Branches for the user with Id " + userId);
        Optional<List<UserBranch>> userBranches = userBranchRepository.retrieveBranchesByUserId(UserEntity.builder().userId(userId).build());

        if(userBranches.isPresent()){
            List<Branch> branches = new ArrayList<>();

            for (UserBranch ub : userBranches.get()){
                ub.getBranch().setToken(ub.getToken());
                ub.getBranch().setUserPriviledge(ub.getUserPriviledge());
                branches.add(ub.getBranch());
            }

            for(Branch branch : branches){
                branch.setStorages(storageService.findAllStorageByBranch(branch));
                branch.setSuppliers(branchService.retrieveSuppliersByBranchId(branch.getBranchId()));
                branch.setEvents(eventService.findOpenEventsByBranchId(branch.getBranchId()));
                branch.setOrders(orderService.findOrderByBranch(branch));
//           branch.setBranchEvent(branchEventStorageService.findOpenEventsByBranchId(branch));
            }
            return branches;
        }else{
            return new ArrayList<>();
        }

    }

    public UserBranch save(UserBranch userBranch){
        return userBranchRepository.save(userBranch);
    }


}
