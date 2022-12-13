package com.acorp.ventimetriquadri.app.event.expences;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenceRepository extends JpaRepository<Expence, Long> {
    @Query("SELECT e FROM Expence e WHERE eventId = ?1")
    List<Expence> findAllByEventId(long eventId);
}
