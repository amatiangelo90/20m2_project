package com.acorp.ventimetriquadri.app.event.event_expences;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventExpenceRepository extends JpaRepository<EventExpence, Long> {
}
