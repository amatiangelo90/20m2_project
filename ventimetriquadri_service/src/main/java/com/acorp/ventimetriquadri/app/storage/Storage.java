package com.acorp.ventimetriquadri.app.storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Storage")
@Table(name = "STORAGE",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"storage_id", "name"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Storage {
    @Id
    @SequenceGenerator(
            name = "storage_id",
            sequenceName = "storage_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "storage_id"
    )
    @Column(
            name = "storage_id",
            updatable = false
    )
    private long storageId;
    private String name = "";
    private String creationDate = "";
    private String address= "";
    private String city = "";
    private int cap;
}
