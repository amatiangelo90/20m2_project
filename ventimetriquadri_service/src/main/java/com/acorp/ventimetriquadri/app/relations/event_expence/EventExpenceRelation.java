package com.acorp.ventimetriquadri.app.relations.event_expence;

import com.acorp.ventimetriquadri.app.event.Event;
import com.acorp.ventimetriquadri.app.event.expences.ExpenceEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "EventExpenceRelation")
@Table(name = "EVENT_EXPENCE_RELATION", uniqueConstraints=
@UniqueConstraint(columnNames={"event_id", "expence_id"}))

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventExpenceRelation implements Serializable {

    @Id
    @SequenceGenerator(
            name = "event_expence_relation_id",
            sequenceName = "event_expence_relation_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "event_expence_relation_id"
    )
    @Column(
            name = "event_expence_relation_id",
            updatable = false
    )
    private long eventExpenceId;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name="event_id")
    private Event event;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name="expence_id")
    private ExpenceEvent expenceEvent;


}
