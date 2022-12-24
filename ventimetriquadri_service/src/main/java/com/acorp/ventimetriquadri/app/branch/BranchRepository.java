package com.acorp.ventimetriquadri.app.branch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
    @Query(value = "SELECT branch FROM Branch branch where phone = ?1")
    Branch findByPhone(String phone);

    @Query(value = "SELECT branch FROM Branch branch where branch.branchCode = ?1")
    Optional<Branch> findByBranchCode(String branchCode);
}
