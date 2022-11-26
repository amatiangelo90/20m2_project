package com.acorp.ventimetriquadri.app.event.event_expences;

import com.acorp.ventimetriquadri.app.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventExpenceRepository extends JpaRepository<EventExpence, Long> {
    @Query("SELECT e FROM EventExpence e WHERE eventId = ?1")
    List<EventExpence> findAllByEventId(long eventId);
}
