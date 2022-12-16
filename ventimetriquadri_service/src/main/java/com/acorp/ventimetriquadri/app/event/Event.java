package com.acorp.ventimetriquadri.app.event;

import com.acorp.ventimetriquadri.app.event.expences.ExpenceEvent;
import com.acorp.ventimetriquadri.app.event.utils.EventStatus;
import com.acorp.ventimetriquadri.app.event.workstations.Workstation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
    private List<ExpenceEvent> expenceEvents;

    @Transient
    private List<Workstation> workstations;

    @Transient
    private long branchId;

    @Transient
    private long storageId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return eventId == event.eventId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(eventId);
    }
}
