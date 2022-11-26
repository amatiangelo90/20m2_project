package com.acorp.ventimetriquadri.app.relations.branch_storage;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.storage.Storage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "BranchStorage")
@Table(name = "BRANCH_STORAGE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchStorage {
    @Id
    @SequenceGenerator(
            name = "branch_storage_id",
            sequenceName = "branch_storage_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "branch_storage_id"
    )
    @Column(
            name = "branch_storage_id",
            updatable = false
    )
    private long branchStorageId;

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="branch_id")
    private Branch branch;

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="storage_id")
    private Storage storage;
}
