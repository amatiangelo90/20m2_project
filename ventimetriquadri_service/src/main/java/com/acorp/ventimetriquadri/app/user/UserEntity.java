package com.acorp.ventimetriquadri.app.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

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
    private String phoneNumber;

}
