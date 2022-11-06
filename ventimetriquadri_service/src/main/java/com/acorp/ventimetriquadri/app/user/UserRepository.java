package com.acorp.ventimetriquadri.app.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
//    @Query(value = "SELECT user FROM UserEntity user where phone = ?1")
//    UserEntity findByPhone(String phone);
}
