package com.acorp.ventimetriquadri.website.repository;

import com.acorp.ventimetriquadri.website.entity.CustomerAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerAccessRepository extends JpaRepository<CustomerAccess, Long> {

    @Query(value = "SELECT u FROM CustomerAccess u where customerId = ?1")
    List<CustomerAccess> findByCustomerId(long customerId);

    @Query(value = "SELECT u FROM CustomerAccess u where customerId = ?1 AND accessDate = ?2")
    Optional<CustomerAccess> findByUserIdAndDate(long customerId, String accessDate);

    @Query(value = "SELECT u FROM CustomerAccess u WHERE accessDate = ?1")
    List<CustomerAccess> findAllCustomerIdsByAccessDate(String date);

    @Query(value = "DELETE FROM CustomerAccess WHERE customerId = ?1")
    void deleteAllAccessesByCustomerId(long customerId);
}
