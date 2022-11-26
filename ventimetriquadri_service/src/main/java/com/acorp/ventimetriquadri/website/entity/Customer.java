package com.acorp.ventimetriquadri.website.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity(name = "Customer")
@Table(name = "CUSTOMER",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"customer_id", "email"}))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {


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
    private String phone;
    private String dob;
    private boolean treatmentPersonalData;

    @Transient
    private List<CustomerAccess> accessesList;

}
