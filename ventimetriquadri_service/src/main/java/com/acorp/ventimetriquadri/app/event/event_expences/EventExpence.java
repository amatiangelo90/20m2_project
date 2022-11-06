package com.acorp.ventimetriquadri.app.event.event_expences;

import com.acorp.ventimetriquadri.app.event.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "EventExpence")
@Table(name = "EVENT_EXPENCE",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"event_expence_id"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventExpence {

    @Id
    @SequenceGenerator(
            name = "event_expence_id",
            sequenceName = "event_expence_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "event_expence_id"
    )
    @Column(
            name = "event_expence_id",
            updatable = false
    )
    private long eventExpenceId;
    private String description;
    private double amount;
    private String dateIntert;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="event_id")
    private Event event;



}
