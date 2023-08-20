
package com.dutta.sai.power.solution.branch.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dutta.sai.power.solution.branch.entity.BranchPayment;
import com.dutta.sai.power.solution.branch.repository.BranchPaymentRespository;
import com.dutta.sai.power.solution.branch.service.BranchPaymentService;

@Service
public class BranchPaymentServiceImpl implements BranchPaymentService {

	@Autowired
	private BranchPaymentRespository paymentRepo;

	@Override
	public List<BranchPayment> getAllBranchePayments() {

		return paymentRepo.findAll();
	}

	@Override
	public List<BranchPayment> getPaymentDetailsByDpCode(int dpCode) {

		return paymentRepo.findAll().stream().filter(branch -> dpCode == branch.getDpcode()).collect(Collectors.toList());
	}

	@Override
	public List<BranchPayment> getPaymentDetailsByName(String branch_name) {

		return paymentRepo.findAll().stream().filter(branch -> branch_name.equals(branch.getBranch_name())).collect(Collectors.toList());
	}

	@Override
	public List<BranchPayment> getPaymentDetailsByYearAndMonth(int year, String month) {

		return paymentRepo.findAll()
		                  .stream()
		                  .filter(branch -> year == branch.getPaymentYear())
		                  .filter(branch -> month.equals(branch.getPaymentMonth()))
		                  .collect(Collectors.toList());
	}

	@Override
	public List<BranchPayment> getPaymentDetailsByYear(int year) {

		return paymentRepo.findAll().stream().filter(branch -> year == branch.getPaymentYear()).collect(Collectors.toList());
	}

	@Override
	public List<BranchPayment> getPaymentDetailsByNameAndYear(String branch_name, int year) {

		return paymentRepo.findAll()
		                  .stream()
		                  .filter(branch -> year == branch.getPaymentYear())
		                  .filter(branch -> branch_name.equals(branch.getBranch_name()))
		                  .collect(Collectors.toList());
	}

	@Override
	public List<BranchPayment> getPaymentDetailsByDpcodeAndYear(int dpCode, int year) {

		return paymentRepo.findAll()
		                  .stream()
		                  .filter(branch -> year == branch.getPaymentYear())
		                  .filter(branch -> dpCode == branch.getDpcode())
		                  .collect(Collectors.toList());
	}

	@Override
	public BranchPayment addBranchPayment(BranchPayment branch) {

		return paymentRepo.save(branch);
	}

	@Override
	public BranchPayment updateBranchPayment(BranchPayment branch) {

		return paymentRepo.save(branch);
	}
}
