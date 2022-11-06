package com.acorp.ventimetriquadri.app.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class SuppliersService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Transactional
    public void addNewBranch(Supplier user) {
        supplierRepository.save(user);
    }

    public void delete(Supplier user){
        supplierRepository.deleteById(user.getSupplierId());
    }

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Transactional
    public void update(Supplier user) {
        Optional<Supplier> updatingUser = supplierRepository.findById(user.getSupplierId());

        if(!updatingUser.isPresent()){
            throw new IllegalStateException("Errore. Non ho trovato utenti da aggiornare");

        }else{

            if(updatingUser.get().getName() != user.getName())
                updatingUser.get().setName(user.getName());

            if(updatingUser.get().getEmail() != user.getEmail())
                updatingUser.get().setEmail(user.getEmail());

            if(updatingUser.get().getPhoneNumber() != user.getPhoneNumber())
                updatingUser.get().setPhoneNumber(user.getPhoneNumber());

            if(updatingUser.get().getPhoneNumber() != user.getPhoneNumber())
                updatingUser.get().setPhoneNumber(user.getPhoneNumber());

            if(updatingUser.get().getPhoneNumber() != user.getPhoneNumber())
                updatingUser.get().setPhoneNumber(user.getPhoneNumber());

            if(updatingUser.get().getPhoneNumber() != user.getPhoneNumber())
                updatingUser.get().setPhoneNumber(user.getPhoneNumber());


        }
    }

    public Supplier findByPhone(String phone) {
        return supplierRepository.findByPhone(phone);
    }
}
