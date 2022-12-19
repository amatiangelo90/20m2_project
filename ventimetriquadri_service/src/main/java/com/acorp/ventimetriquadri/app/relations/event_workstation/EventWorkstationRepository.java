package com.acorp.ventimetriquadri.app.relations.event_workstation;

import com.acorp.ventimetriquadri.app.event.Event;
import com.acorp.ventimetriquadri.app.event.workstations.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventWorkstationRepository extends JpaRepository<EventWorkstationRelation, Long> {

    @Query("SELECT ew.workstation FROM EventWorkstationRelation ew WHERE ew.event = ?1")
    List<Workstation> findAllWorkstationsByEvent(Event event);


    @Modifying
    @Query("DELETE FROM EventWorkstationRelation ew WHERE ew.workstation = ?1")
    void removeByWorkstationId(Workstation workstation);
}
