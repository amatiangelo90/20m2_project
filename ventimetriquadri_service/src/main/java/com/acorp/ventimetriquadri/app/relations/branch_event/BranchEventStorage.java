package com.acorp.ventimetriquadri.app.relations.branch_event;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.event.Event;
import com.acorp.ventimetriquadri.app.storage.Storage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "BranchEventStorage")
@Table(name = "BRANCH_EVENT_STORAGE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchEventStorage {

    @Id
    @SequenceGenerator(
            name = "branch_event_id",
            sequenceName = "branch_event_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "branch_event_id"
    )
    @Column(
            name = "branch_event_id",
            updatable = false
    )
    private long branchEventId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="branch_id")
    private Branch branch;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="event_id")
    private Event event;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="storage_id")
    private Storage storage;

}
