package com.acorp.ventimetriquadri.app.relations.workstation_product;

import com.acorp.ventimetriquadri.app.event.workstations.Workstation;
import com.acorp.ventimetriquadri.app.product.product_utils.UnitMeasure;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "WorkstationProduct")
@Table(name = "WORKSTATION_PRODUCT", uniqueConstraints=
@UniqueConstraint(columnNames={"product_id", "workstation_id"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WorkstationProduct {

    @Id
    @SequenceGenerator(
            name = "workstation_product_id",
            sequenceName = "workstation_product_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "workstation_product_id"
    )
    @Column(
            name = "workstation_product_id",
            updatable = false
    )
    private long workstationProductId;

    @Column(
            name = "product_id",
            updatable = false
    )
    private long productId;
    private String productName;

    @Enumerated
    private UnitMeasure unitMeasure;
    private double stockFromStorage;
    private double consumed;

    private double amountHundred;

    @Column(
            name = "storage_id",
            updatable = false
    )
    private long storageId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="workstation_id")
    @JsonIgnore
    private Workstation workstation;

}
