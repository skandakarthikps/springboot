
package com.dutta.sai.power.solution.branch.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Branch_Details")
public class BranchDetails {

	@Id
	@Column(name = "DP_CODE", nullable = false)
	private int dpcode;
	@Column(name = "Branch_Name", nullable = false)
	private String branch_name;
	@Column(name = "LOCATION", nullable = false)
	private String location;
	@Column(name = "PINCODE", nullable = false)
	private int pincode;
	@Column(name = "DG_MAKE", nullable = false)
	private String dgMake;
	@Column(name = "DG_KVA", nullable = false)
	private String dgKVA;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "Branch_Start_Date")
	private String branchStartDate;
	@Column(name = "Hour_Meter")
	private int currentReading;
	@Column(name = "BASIC_AMOUNT")
	private BigDecimal basicAmount;
	@Column(name = "EXTRA_HR_RATE")
	private BigDecimal extraHrsRate;
	@Column(name = "Branch_Type")
	private String branchType;
	@Column(name = "RO")
	private String ro;
}
