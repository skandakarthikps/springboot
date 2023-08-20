
package com.dutta.sai.power.solution.branch.service;

import java.util.List;

import com.dutta.sai.power.solution.branch.entity.BranchPayment;

public interface BranchPaymentService {

	List<BranchPayment> getAllBranchePayments();

	List<BranchPayment> getPaymentDetailsByDpCode(int dpCode);

	List<BranchPayment> getPaymentDetailsByName(String branch_name);

	List<BranchPayment> getPaymentDetailsByYearAndMonth(int year, String month);

	List<BranchPayment> getPaymentDetailsByYear(int year);

	List<BranchPayment> getPaymentDetailsByNameAndYear(String branch_name, int year);

	List<BranchPayment> getPaymentDetailsByDpcodeAndYear(int dpCode, int year);

	BranchPayment addBranchPayment(BranchPayment branch);

	BranchPayment updateBranchPayment(BranchPayment branch);
}
