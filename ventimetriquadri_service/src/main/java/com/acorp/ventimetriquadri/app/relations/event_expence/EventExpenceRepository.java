package com.acorp.ventimetriquadri.app.relations.event_expence;

import com.acorp.ventimetriquadri.app.event.Event;
import com.acorp.ventimetriquadri.app.event.expences.ExpenceEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventExpenceRepository extends JpaRepository<EventExpenceRelation, Long> {

    @Query("SELECT ee.expenceEvent FROM EventExpenceRelation ee WHERE ee.event = ?1")
    List<ExpenceEvent> findAllByEvent(Event event);

}
