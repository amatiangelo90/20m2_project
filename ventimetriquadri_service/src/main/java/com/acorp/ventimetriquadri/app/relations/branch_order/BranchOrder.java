package com.acorp.ventimetriquadri.app.relations.branch_order;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.order.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "BranchOrder")
@Table(name = "BRANCH_ORDER")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchOrder implements Serializable {
    @Id
    @SequenceGenerator(
            name = "branch_order_id",
            sequenceName = "branch_order_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "branch_order_id"
    )
    @Column(
            name = "branch_order_id",
            updatable = false
    )
    private long branchOrderId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="branch_id")
    private Branch branch;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id")
    private OrderEntity orderEntity;

}
