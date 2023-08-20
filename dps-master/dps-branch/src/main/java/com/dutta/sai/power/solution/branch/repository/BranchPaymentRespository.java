
package com.dutta.sai.power.solution.branch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dutta.sai.power.solution.branch.entity.BranchPayment;

public interface BranchPaymentRespository extends JpaRepository<BranchPayment, Integer> {
}
