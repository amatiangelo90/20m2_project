package com.acorp.ventimetriquadri.website.repository;

import com.acorp.ventimetriquadri.website.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumersRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT u FROM Customer u where phone = ?1")
    Customer findByPhone(String phone);

    @Query(value = "SELECT u FROM Customer u WHERE customer_id IN ?1")
    List<Customer> findAllInIds(List<Long> idsCustomers);
}
