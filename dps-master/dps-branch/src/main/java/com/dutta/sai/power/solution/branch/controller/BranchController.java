
package com.dutta.sai.power.solution.branch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dutta.sai.power.solution.branch.entity.BranchDetails;
import com.dutta.sai.power.solution.branch.service.impl.BranchServiceImpl;

@RestController
public class BranchController {

	@Autowired
	private BranchServiceImpl branchService;

	@RequestMapping(value = "/allActiveBranches")
	public List<BranchDetails> getAllActiveBranches(Model model) {

		return branchService.getAllActiveBranches();
	}

	@PostMapping("/addBranch")
	public BranchDetails addBranch(@RequestBody BranchDetails branch) {

		return branchService.addBranch(branch);
	}

	@GetMapping("/branch/{id}")
	public BranchDetails getBranchDetailsByID(@PathVariable("id") int id) {

		return branchService.getBranchByDpCode(id);
	}

	@PostMapping("/branch/update")
	public BranchDetails updateBranchDetails(@RequestBody BranchDetails branch) {

		BranchDetails temp = branchService.getBranchByDpCode(branch.getDpcode());
		branch.setCurrentReading(temp.getCurrentReading());
		return branchService.updateBranch(branch);
	}

	@RequestMapping(value = "/allBranches")
	public List<BranchDetails> getAllBranches(Model model) {

		return branchService.getAllBranches();
	}

	@RequestMapping(value = "/getBranchByName/{name}")
	public BranchDetails getBranchByName(@PathVariable("name") String name) {

		return branchService.getAllActiveBranches().stream().filter(branch -> name.equals(branch.getBranch_name())).findFirst().get();
	}

	@RequestMapping(name = "/updateBranchReading/{branch}/{reading}")
	public BranchDetails updateBranchReading(@PathVariable("reading") int reading, @PathVariable("branch") String branch) {

		BranchDetails temp = branchService.getBranchByDpCode(Integer.parseInt(branch.substring(0, branch.indexOf("#"))));
		temp.setCurrentReading(reading);
		return branchService.updateBranch(temp);
	}
}
