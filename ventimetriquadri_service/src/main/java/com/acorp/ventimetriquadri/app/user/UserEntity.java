package com.acorp.ventimetriquadri.app.user;

import com.acorp.ventimetriquadri.app.branch.Branch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "UserEntity")
@Table(name = "USER_ENTITY",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"user_id", "email"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserEntity {

    @Id
    @SequenceGenerator(
            name = "user_id",
            sequenceName = "user_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id"
    )
    @Column(
            name = "user_id",
            updatable = false
    )
    private long userId;

    private String name = "";
    private String lastname = "";

    @Column(
            name = "email",
            unique = true,
            nullable = false
    )
    private String email = "";
    @Column(
            name = "phone",
            unique = true,
            nullable = false
    )
    private String phone = "";

    @Transient
    List<Branch> branchList = new ArrayList<>();

}
