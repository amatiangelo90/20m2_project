package com.acorp.ventimetriquadri.app.branch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Branch")
@Table(name = "BRANCH",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"branch_id", "name"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Branch {

    @Id
    @SequenceGenerator(
            name = "branch_id",
            sequenceName = "branch_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "branch_id"
    )
    @Column(
            name = "branch_id",
            updatable = false
    )
    private long branchId;

    private String name = "";
    private String email = "";
    private String vatNumber;
    private String address;
    private String city;
    private String cap;
    @Column(
            name = "phone",
            unique = true,
            nullable = false
    )
    private String phoneNumber;
}
