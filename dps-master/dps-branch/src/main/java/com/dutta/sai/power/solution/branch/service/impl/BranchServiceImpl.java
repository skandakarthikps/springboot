
package com.dutta.sai.power.solution.branch.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dutta.sai.power.solution.branch.entity.BranchDetails;
import com.dutta.sai.power.solution.branch.repository.BranchRepository;
import com.dutta.sai.power.solution.branch.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchRepository branchRepo;

	@Override
	public List<BranchDetails> getAllActiveBranches() {

		return branchRepo.findAll().stream().filter(branch -> branch.getStatus().equals("Active")).collect(Collectors.toList());
	}

	@Override
	public BranchDetails getBranchByDpCode(int dpCode) {

		return branchRepo.findById(dpCode).get();
	}

	@Override
	public BranchDetails addBranch(BranchDetails branch) {

		return branchRepo.save(branch);
	}

	@Override
	public BranchDetails updateBranch(BranchDetails branch) {

		return branchRepo.save(branch);
	}

	@Override
	public void deleteBranch(int dpCode) {

		branchRepo.deleteById(dpCode);
	}

	@Override
	public List<BranchDetails> getAllBranches() {

		return branchRepo.findAll();
	}
}
