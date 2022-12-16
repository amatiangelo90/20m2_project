package com.acorp.ventimetriquadri.app.event.expences;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "ExpenceEvent")
@Table(name = "EXPENCE_EVENT",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"expence_event_id"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExpenceEvent {

    @Id
    @SequenceGenerator(
            name = "expence_event_id",
            sequenceName = "expence_event_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "expence_event_id"
    )
    @Column(
            name = "expence_event_id",
            updatable = false
    )
    private long expenceId;
    private String description;
    private double amount;
    private String dateIntert;

    @JsonIgnore
    private long eventId;

}
