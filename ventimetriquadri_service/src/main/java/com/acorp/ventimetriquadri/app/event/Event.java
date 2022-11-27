package com.acorp.ventimetriquadri.app.event;

import com.acorp.ventimetriquadri.app.event.event_expences.EventExpence;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Event")
@Table(name = "EVENT",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"event_id", "name"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Event implements Serializable {


    @Id
    @SequenceGenerator(
            name = "event_id",
            sequenceName = "event_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "event_id"
    )
    @Column(
            name = "event_id",
            updatable = false
    )
    private long eventId;

    private String name = "";
    private String dateEvent = "";
    private String dateCreation = "";
    @Enumerated
    private EventStatus eventStatus;

    private String location = "";

    @Transient
    private List<EventExpence> eventExpences;


}
