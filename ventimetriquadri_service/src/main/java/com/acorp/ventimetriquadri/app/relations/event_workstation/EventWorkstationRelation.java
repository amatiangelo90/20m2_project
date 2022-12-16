package com.acorp.ventimetriquadri.app.relations.event_workstation;

import com.acorp.ventimetriquadri.app.event.Event;
import com.acorp.ventimetriquadri.app.event.workstations.Workstation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity(name = "EventWorkstationRelation")
@Table(name = "EVENT_WORKSTATION_RELATION", uniqueConstraints=
@UniqueConstraint(columnNames={"event_id", "workstation_id"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventWorkstationRelation {

    @Id
    @SequenceGenerator(
            name = "event_workstation_relation_id",
            sequenceName = "event_workstation_relation_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "event_workstation_relation_id"
    )
    @Column(
            name = "event_workstation_relation_id",
            updatable = false
    )
    private long eventWorkstationId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="event_id")
    private Event event;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="workstation_id")
    private Workstation workstation;
}
