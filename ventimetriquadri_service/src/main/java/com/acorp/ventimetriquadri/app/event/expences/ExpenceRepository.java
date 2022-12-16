package com.acorp.ventimetriquadri.app.event.expences;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenceRepository extends JpaRepository<ExpenceEvent, Long> {
    @Query("SELECT e FROM ExpenceEvent e WHERE eventId = ?1")
    List<ExpenceEvent> findAllByEventId(long eventId);
}
