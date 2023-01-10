package com.acorp.ventimetriquadri.app.supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query(value = "SELECT supplier FROM Supplier supplier where supplier.supplierCode = ?1")
    Supplier findByCode(String code);
}
