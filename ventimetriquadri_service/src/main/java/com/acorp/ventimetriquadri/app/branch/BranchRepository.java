package com.acorp.ventimetriquadri.app.branch;

import com.acorp.ventimetriquadri.app.branch.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
    @Query(value = "SELECT branch FROM Branch branch where phone = ?1")
    Branch findByPhone(String phone);
}
