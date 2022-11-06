package com.acorp.ventimetriquadri.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void addNewBranch(UserEntity userEntity) {
        userRepository.save(userEntity);
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

            if(updatingUser.get().getPhoneNumber() != userEntity.getPhoneNumber())
                updatingUser.get().setPhoneNumber(userEntity.getPhoneNumber());

        }
    }

//    public UserEntity findByPhone(String phone) {
//        return userRepository.findByPhone(phone);
//    }
}
