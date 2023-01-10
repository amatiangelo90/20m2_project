package com.acorp.ventimetriquadri.app.relations.workstation_product;

import com.acorp.ventimetriquadri.app.event.workstations.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkstationProductRepository extends JpaRepository<WorkstationProduct, Long> {

    @Query("SELECT wp FROM WorkstationProduct wp WHERE wp.workstation = ?1 ORDER BY wp.productName ASC")
    List<WorkstationProduct> findProductsAvailableByWorkstation(Workstation workstation);

    @Modifying
    @Query(value = "UPDATE WorkstationProduct wp SET wp.amountHundred = ?1 WHERE wp.productId = ?2")
    void updateAmountHundredByProductId(double qHundredAmount, long productId);

    @Modifying
    @Query(value = "UPDATE WorkstationProduct wp SET wp.leftovers = ?1 WHERE wp.workstationProductId = ?2")
    void updateLeftOversValue(double leftovers, long workstationProductId);
}
