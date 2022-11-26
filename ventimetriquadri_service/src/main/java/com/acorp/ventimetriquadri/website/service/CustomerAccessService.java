package com.acorp.ventimetriquadri.website.service;

import com.acorp.ventimetriquadri.website.entity.CustomerAccess;
import com.acorp.ventimetriquadri.website.repository.CustomerAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerAccessService {

    @Autowired
    private CustomerAccessRepository customerAccessRepository;

    @Transactional
    public void addNewCustAccess(CustomerAccess customerAccess) {
        Optional<CustomerAccess> accessByUserIdAndDate
                = customerAccessRepository.findByUserIdAndDate(customerAccess.getCustomerId(), customerAccess.getAccessDate());

        if(accessByUserIdAndDate.isPresent()){
            accessByUserIdAndDate.get().setBranchLocation(customerAccess.getBranchLocation());
        }else {
            customerAccessRepository.save(customerAccess);
        }
    }

    public void delete(CustomerAccess customerAccess){
        customerAccessRepository.deleteById(customerAccess.getCustomerAccessId());
    }

    public List<CustomerAccess> findAll() {
       return customerAccessRepository.findAll();
    }

    public List<CustomerAccess> findByCustomerId(long customerId) {
        return customerAccessRepository.findByCustomerId(customerId);
    }

    public void deleteById(long customerId) {
        customerAccessRepository.deleteById(customerId);
    }

}
