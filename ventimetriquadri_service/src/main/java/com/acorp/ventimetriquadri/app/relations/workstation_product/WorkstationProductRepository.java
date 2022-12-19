package com.acorp.ventimetriquadri.app.relations.workstation_product;

import com.acorp.ventimetriquadri.app.event.workstations.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkstationProductRepository extends JpaRepository<WorkstationProduct, Long> {

    @Query("SELECT wp FROM WorkstationProduct wp WHERE wp.workstation = ?1")
    List<WorkstationProduct> findProductsAvailableByWorkstation(Workstation workstation);


}
