
package com.dutta.sai.power.solution.branch.service;

import java.util.List;

import com.dutta.sai.power.solution.branch.entity.BranchDetails;

public interface BranchService {

	List<BranchDetails> getAllActiveBranches();

	BranchDetails getBranchByDpCode(int dpCode);

	BranchDetails addBranch(BranchDetails branch);

	BranchDetails updateBranch(BranchDetails branch);

	void deleteBranch(int dpCode);

	List<BranchDetails> getAllBranches();
}
