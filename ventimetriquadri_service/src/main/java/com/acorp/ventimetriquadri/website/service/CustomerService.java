package com.acorp.ventimetriquadri.website.service;

import com.acorp.ventimetriquadri.website.PienissimoClient;
import com.acorp.ventimetriquadri.website.entity.BranchLocation;
import com.acorp.ventimetriquadri.website.entity.Customer;
import com.acorp.ventimetriquadri.website.entity.CustomerAccess;
import com.acorp.ventimetriquadri.website.entity.PienissimoEntity;
import com.acorp.ventimetriquadri.website.repository.ConsumersRepository;
import com.acorp.ventimetriquadri.website.repository.CustomerAccessRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Thread.sleep;


@Service
public class CustomerService {

    @Autowired
    private ConsumersRepository consumersRepository;

    @Autowired
    private CustomerAccessRepository customerAccessRepository;

    @Transactional
    public long addNewCustmer(Customer customer) {
        consumersRepository.save(customer);
        return customer.getCustomerId();
    }

    @Transactional
    public void delete(Customer customer){

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
        List<CustomerAccess> accessOnCurrentDateList = customerAccessRepository.findAllCustomerIdsByAccessDate(date);
        List<Customer> allCustomersInIds = consumersRepository.findAllInIds(getCustomersIdsList(accessOnCurrentDateList));

        for(Customer customer : allCustomersInIds){
            customer.setAccessesList(customerAccessRepository.findByCustomerId(customer.getCustomerId()));
        }
        return allCustomersInIds;
    }

    private List<CustomerAccess> getAccessListByCustomerId(List<CustomerAccess> accessOnCurrentDateList,
                                                           long customerId) {

        List<CustomerAccess> customerAccesses = new ArrayList<>();

        for (CustomerAccess customerAccess : accessOnCurrentDateList){
            if(customerAccess.getCustomerId() == customerId){
                customerAccesses.add(customerAccess);
            }
        }

        return customerAccesses;

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
        consumersRepository.deleteById(customerId);
        customerAccessRepository.deleteAllAccessesByCustomerId(customerId);
    }


    public Customer findByPhone(String phone) {
        return consumersRepository.findByPhone(phone);
    }

}
