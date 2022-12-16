package com.acorp.ventimetriquadri.app.event.workstations;

import com.acorp.ventimetriquadri.app.event.utils.WorkstationStatus;
import com.acorp.ventimetriquadri.app.event.utils.WorkstationType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Workstation")
@Table(name = "WORKSTATION",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"workstation_id", "name"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Workstation {

    @Id
    @SequenceGenerator(
            name = "workstation_id",
            sequenceName = "workstation_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "workstation_id"
    )
    @Column(
            name = "workstation_id",
            updatable = false
    )
    private long workstationId;
    private String name = "";
    private String responsable;
    private String extra;

    @Enumerated
    private WorkstationType workstationType;

    @Enumerated
    private WorkstationStatus workstationStatus;

    @JsonIgnore
    private long eventId;


}
