
package com.dutta.sai.power.solution.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private long empId;
	private String empFirstName;
	private String empLastName;
	private String dob;
	private String joining_date;
	private long empMobile;
	private String empEmail;
	private String designation;
	private String empAddress;
	private long salary;
	private String bankName;
	private long accountNumber;
	private String ifscCode;
	private String branch;
	private String exist_date;
}
