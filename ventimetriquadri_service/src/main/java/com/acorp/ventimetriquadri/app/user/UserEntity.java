package com.acorp.ventimetriquadri.app.user;

import com.acorp.ventimetriquadri.app.relations.user_branch.UserBranch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "User_Entity")
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
    private String email = "";
    @Column(
            name = "phone",
            unique = true,
            nullable = false
    )
    private String phoneNumber;

}
