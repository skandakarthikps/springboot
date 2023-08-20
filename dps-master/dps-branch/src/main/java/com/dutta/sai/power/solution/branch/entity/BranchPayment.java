
package com.dutta.sai.power.solution.branch.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Branch_Payment")
public class BranchPayment {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_id")
	@SequenceGenerator(name = "payment_id", sequenceName = "PAYMENT_ID_SEQ")
	private int id;
	@Column(name = "DP_CODE", nullable = false)
	private int dpcode;
	@Column(name = "Branch_Name", nullable = false)
	private String branch_name;
	@Column(name = "LOCATION", nullable = false)
	private String location;
	@Column(name = "DG_DETAILS", nullable = false)
	private String dgDetails;
	@Column(name = "PYMT_YEAR")
	private int paymentYear;
	@Column(name = "PYMT_MONTH")
	private String paymentMonth;
	@Column(name = "OLD_READING")
	private int oldReading;
	@Column(name = "NEW_READING")
	private int newReading;
	@Column(name = "BASIC_AMT")
	private BigDecimal basicAmount;
	@Column(name = "EXTRA_HR_RATE")
	private BigDecimal extraHrRate;
	@Column(name = "EXTRA_HOURS")
	private int extraHours;
	@Column(name = "EXTRA_HOURS_AMT")
	private BigDecimal extraHoursAmount;
	@Column(name = "NET_AMT")
	private BigDecimal netAmount;
	@Column(name = "CGST")
	private int cgst;
	@Column(name = "SGST")
	private int sgst;
	@Column(name = "TOTAL_AMT")
	private BigDecimal totalAmount;
	@Column(name = "LAST_UPDATED_DATE")
	private String updatedDate;
}
