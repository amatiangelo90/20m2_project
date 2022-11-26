package com.acorp.ventimetriquadri.website.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "CustomerAccess")
@Table(name = "CUSTOMER_ACCESS",
        uniqueConstraints= @UniqueConstraint(columnNames={"customer_access_id"})
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAccess implements Serializable {
    @Id
    @SequenceGenerator(
            name = "customer_access_id",
            sequenceName = "customer_access_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_access_id"
    )
    @Column(
            name = "customer_access_id",
            updatable = false
    )
    @JsonIgnore
    private long customerAccessId;

    @Column(
            name = "access_date",
            updatable = false
    )
    private String accessDate;
    private BranchLocation branchLocation;

    @Column(
            name = "customer_id",
            updatable = false
    )
    @JsonIgnore
    private long customerId;
}
