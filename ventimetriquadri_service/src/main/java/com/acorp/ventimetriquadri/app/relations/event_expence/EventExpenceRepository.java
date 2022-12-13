package com.acorp.ventimetriquadri.app.relations.event_expence;

import com.acorp.ventimetriquadri.app.event.Event;
import com.acorp.ventimetriquadri.app.event.expences.Expence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventExpenceRepository extends JpaRepository<EventExpence, Long> {

    @Query("SELECT ee.expence FROM EventExpence ee WHERE ee.event = ?1")
    List<Expence> findAllByEvent(Event event);

}
