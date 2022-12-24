package com.acorp.ventimetriquadri.app.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT ue FROM UserEntity ue WHERE email = ?1")
    Optional<UserEntity> findByEmail(String email);
}
