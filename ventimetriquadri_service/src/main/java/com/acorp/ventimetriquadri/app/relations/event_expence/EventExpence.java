package com.acorp.ventimetriquadri.app.relations.event_expence;

import com.acorp.ventimetriquadri.app.event.Event;
import com.acorp.ventimetriquadri.app.event.expences.Expence;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "EventExpence")
@Table(name = "EVENT_EXPENCE")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventExpence implements Serializable {

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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="event_id")
    private Event event;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="expence_id")
    private Expence expence;


}
