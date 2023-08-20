
package com.dutta.sai.power.solution.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDetails {

	private int dpcode;
	private String branch_name;
	private String location;
	private int pincode;
	private String dgMake;
	private String dgKVA;
	private String status;
	private String branchStartDate;
	private int currentReading;
	private BigDecimal basicAmount;
	private BigDecimal extraHrsRate;
	private String branchType;
	private String ro;
}
