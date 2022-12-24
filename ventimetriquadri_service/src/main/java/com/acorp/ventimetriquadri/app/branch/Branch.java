package com.acorp.ventimetriquadri.app.branch;

import com.acorp.ventimetriquadri.app.event.Event;
import com.acorp.ventimetriquadri.app.order.OrderEntity;
import com.acorp.ventimetriquadri.app.relations.user_branch.UserPriviledge;
import com.acorp.ventimetriquadri.app.storage.Storage;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity(name = "Branch")
@Table(name = "BRANCH",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"branch_id", "name", "branchCode"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Branch implements Serializable {

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

    @Column(
            name = "branchCode",
            nullable = false,
            unique = true,
            length = 8
    )
    private String branchCode;

    private String name = "";
    private String email = "";
    private String vatNumber;
    private String address;
    private String city;
    private String cap;
    @Column(
            name = "phone",
            nullable = false
    )
    private String phoneNumber;

    @Transient
    private long userId;

    @Transient
    private List<Storage> storages;

    @Transient
    private List<Supplier> suppliers;

    @Transient
    private List<Event> events;

    @Transient
    private List<OrderEntity> orders;

    @Transient
    private String token;

    @Transient
    @Enumerated
    private UserPriviledge userPriviledge;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Branch)) return false;
        Branch branch = (Branch) o;
        return branchId == branch.branchId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(branchId);
    }
}
