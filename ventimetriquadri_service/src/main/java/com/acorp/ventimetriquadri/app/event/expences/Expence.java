package com.acorp.ventimetriquadri.app.event.expences;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Expence")
@Table(name = "EXPENCE",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"expence_id"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Expence {

    @Id
    @SequenceGenerator(
            name = "expence_id",
            sequenceName = "expence_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "expence_id"
    )
    @Column(
            name = "expence_id",
            updatable = false
    )
    private long expenceId;
    private String description;
    private double amount;
    private String dateIntert;

    @Column(
            name = "event_id",
            updatable = false
    )
    @JsonIgnore
    private long eventId;

}
