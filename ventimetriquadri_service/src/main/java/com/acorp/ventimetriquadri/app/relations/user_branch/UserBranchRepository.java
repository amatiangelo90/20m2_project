package com.acorp.ventimetriquadri.app.relations.user_branch;

import com.acorp.ventimetriquadri.app.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBranchRepository extends JpaRepository<UserBranch, Long> {

    @Query("SELECT ub FROM UserBranch ub WHERE ub.userEntity = ?1")
    List<UserBranch> retrieveBranchesByUserId(UserEntity user);
}
