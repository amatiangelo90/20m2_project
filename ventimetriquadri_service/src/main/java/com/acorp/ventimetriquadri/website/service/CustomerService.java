package com.acorp.ventimetriquadri.website.service;

import com.acorp.ventimetriquadri.website.entity.Customer;
import com.acorp.ventimetriquadri.website.entity.CustomerAccess;
import com.acorp.ventimetriquadri.website.repository.ConsumersRepository;
import com.acorp.ventimetriquadri.website.repository.CustomerAccessRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private ConsumersRepository consumersRepository;

    @Autowired
    private CustomerAccessRepository customerAccessRepository;

    @Transactional
    public long addNewCustmer(Customer customer) {
        logger.info("Save current customer: " + customer.toString());
        consumersRepository.save(customer);
        return customer.getCustomerId();
    }

    @Transactional
    public void delete(Customer customer){
        logger.info("Delete current customer : " + customer.toString());
        consumersRepository.deleteById(customer.getCustomerId());

    }

    public List<Customer> findAll() {
        List<Customer> allCustomers = consumersRepository.findAll();
        for(Customer customer : allCustomers){
            customer.setAccessesList(customerAccessRepository.findByCustomerId(customer.getCustomerId()));
        }
        return allCustomers;
    }


    public List<Customer> findAllByDate(String date) {
        logger.info("Find all customer by access date : " + date);
        List<CustomerAccess> accessOnCurrentDateList = customerAccessRepository.findAllCustomerIdsByAccessDate(date);
        List<Customer> allCustomersInIds = consumersRepository.findAllInIds(getCustomersIdsList(accessOnCurrentDateList));

        for(Customer customer : allCustomersInIds){
            customer.setAccessesList(customerAccessRepository.findByCustomerId(customer.getCustomerId()));
        }
        logger.info("Customer found for date [" + date + "] : " + allCustomersInIds.toString());
        return allCustomersInIds;
    }

    private List<Long> getCustomersIdsList(List<CustomerAccess> accessOnCurrentDateList) {
        List<Long> ids = new ArrayList<>();
        for(CustomerAccess customerAccess : accessOnCurrentDateList){
            ids.add(customerAccess.getCustomerId());
        }
        return ids;
    }

    @Transactional
    public void update(Customer customer) {
        logger.info("Updating current customer: " + customer);
        Optional<Customer> updatingCustomer = consumersRepository.findById(customer.getCustomerId());

        if(!updatingCustomer.isPresent()){
            throw new IllegalStateException("Errore. Non ho trovato utenti da aggiornare");

        }else{
            consumersRepository.delete(customer);
            consumersRepository.save(customer);
        }
    }

    @Transactional
    public void deleteById(long customerId) {
        logger.info("Delete customer with id: " + customerId);
        consumersRepository.deleteById(customerId);
        customerAccessRepository.deleteAllAccessesByCustomerId(customerId);
    }

    public Customer findByPhone(String phone) {
        logger.info("Retrieve customer by phone: " + phone);
        Customer byPhone = consumersRepository.findByPhone(phone);
        logger.info("Retrieved customer by phone  [" + phone + "] : " + byPhone.toString());
        return byPhone;
    }

}
