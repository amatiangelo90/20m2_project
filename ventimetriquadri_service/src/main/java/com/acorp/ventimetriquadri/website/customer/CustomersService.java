package com.acorp.ventimetriquadri.website.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class CustomersService {

    @Autowired
    private ConsumersRepository consumersRepository;

    @Transactional
    public void addNewCustmer(Customers customers) {
        consumersRepository.save(customers);
    }

    public void delete(Customers customers){
        consumersRepository.deleteById(customers.getCustomerId());
    }

    public List<Customers> findAll() {
        return consumersRepository.findAll();
    }

    @Transactional
    public void update(Customers customers) {
        Optional<Customers> updatingCustomer = consumersRepository.findById(customers.getCustomerId());

        if(!updatingCustomer.isPresent()){
            throw new IllegalStateException("Errore. Non ho trovato utenti da aggiornare");

        }else{

            if(updatingCustomer.get().getName() != customers.getName())
                updatingCustomer.get().setName(customers.getName());

            if(updatingCustomer.get().getDob() != customers.getDob())
                updatingCustomer.get().setDob(customers.getDob());

            if(updatingCustomer.get().getEmail() != customers.getEmail())
                updatingCustomer.get().setEmail(customers.getEmail());

            if(updatingCustomer.get().getPhoneNumber() != customers.getPhoneNumber())
                updatingCustomer.get().setPhoneNumber(customers.getPhoneNumber());

        }
    }

    public Customers findByPhone(String phone) {
        return consumersRepository.findByPhone(phone);
    }
}
