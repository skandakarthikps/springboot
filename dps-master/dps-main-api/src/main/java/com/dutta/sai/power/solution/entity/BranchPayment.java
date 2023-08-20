
package com.dutta.sai.power.solution.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchPayment {

	private int id;
	private int dpcode;
	private String branch_name;
	private String location;
	private String dgDetails;
	private int paymentYear;
	private String paymentMonth;
	private int oldReading;
	private int newReading;
	private BigDecimal extraHrRate;
	private BigDecimal basicAmount;
	private int extraHours;
	private BigDecimal extraHoursAmount;
	private BigDecimal netAmount;
	private int cgst;
	private int sgst;
	private BigDecimal totalAmount;
	private String updatedDate;
}
