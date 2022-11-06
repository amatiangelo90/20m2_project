package com.acorp.ventimetriquadri.website.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Customers")
@Table(name = "CUSTOMERS",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"customer_id", "email"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Customers {

    @Id
    @SequenceGenerator(
            name = "customer_id",
            sequenceName = "customer_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id"
    )
    @Column(
            name = "customer_id",
            updatable = false
    )
    private long customerId;

    private String name = "";
    private String lastname = "";
    private String email = "";
    @Column(
            name = "phone",
            unique = true,
            nullable = false
    )
    private String phoneNumber;
    private String dob;
    private boolean treatmentPersonalData;
    private BranchLocation branch20m2;
    private int accessCounter;
}
