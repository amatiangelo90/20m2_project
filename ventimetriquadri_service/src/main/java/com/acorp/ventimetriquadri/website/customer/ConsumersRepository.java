package com.acorp.ventimetriquadri.website.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumersRepository extends JpaRepository<Customers, Long> {
    @Query(value = "SELECT u FROM Customers u where phoneNumber = ?1")
    Customers findByPhone(String phone);
}
