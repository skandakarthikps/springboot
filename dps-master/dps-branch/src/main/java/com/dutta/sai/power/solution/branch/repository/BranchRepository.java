
package com.dutta.sai.power.solution.branch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dutta.sai.power.solution.branch.entity.BranchDetails;

public interface BranchRepository extends JpaRepository<BranchDetails, Integer> {
}
