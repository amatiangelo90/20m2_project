package com.acorp.ventimetriquadri.app.event.expences;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenceRepository extends JpaRepository<ExpenceEvent, Long> {
    @Query("SELECT e FROM ExpenceEvent e WHERE e.eventId = ?1")
    List<ExpenceEvent> findAllByEventId(long eventId);


    @Modifying
    @Query("DELETE FROM ExpenceEvent e WHERE e.eventId = ?1")
    void removeByEventId(long eventId);
}
