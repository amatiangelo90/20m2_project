package com.acorp.ventimetriquadri.app.relations.branch_event;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.event.Event;
import com.acorp.ventimetriquadri.app.storage.Storage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "BranchEventStorage")
@Table(name = "BRANCH_EVENT_STORAGE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchEventStorage implements Serializable {

    @Id
    @SequenceGenerator(
            name = "branch_event_storage_id",
            sequenceName = "branch_event_storage_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "branch_event_storage_id"
    )
    @Column(
            name = "branch_event_storage_id",
            updatable = false
    )
    private long branchEventStorageId;

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
