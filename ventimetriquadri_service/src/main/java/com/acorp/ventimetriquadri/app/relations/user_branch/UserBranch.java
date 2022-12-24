package com.acorp.ventimetriquadri.app.relations.user_branch;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "UserBranch")
@Table(name = "USER_BRANCH",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"branch_id", "user_id"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserBranch {

    @Id
    @SequenceGenerator(
            name = "userbranchid",
            sequenceName = "userbranchid",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userbranchid"
    )
    @Column(
            name = "userbranchid",
            updatable = false
    )
    private long userbranchid;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="branch_id")
    private Branch branch;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserEntity userEntity;

    @Enumerated
    private UserPriviledge userPriviledge;

    private String token;

}
