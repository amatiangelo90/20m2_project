package com.acorp.ventimetriquadri.app.supplier;

import com.acorp.ventimetriquadri.app.branch.Branch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Supplier")
@Table(name = "SUPPLIER",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"supplier_id", "email"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Supplier {

    @Id
    @SequenceGenerator(
            name = "supplier_id",
            sequenceName = "supplier_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "supplier_id"
    )
    @Column(
            name = "supplier_id",
            updatable = false
    )
    private long supplierId;
    private String name = "";
    private String vatNumber = "";
    private String address;
    private String city;
    private String cap;
    @Column(
            name = "phone",
            unique = true,
            nullable = false
    )
    private String phoneNumber;
    private String email;
    private String pec;

}
