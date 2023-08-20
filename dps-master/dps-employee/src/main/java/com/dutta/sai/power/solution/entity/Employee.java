
package com.dutta.sai.power.solution.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employees")
public class Employee {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_id_seq")
	@SequenceGenerator(name = "emp_id_seq", sequenceName = "EMP_ID_SEQ")
	private long empId;
	@Column(name = "First_Name", nullable = false)
	private String empFirstName;
	@Column(name = "Last_Name")
	private String empLastName;
	@Column(name = "Date_Of_Birth")
	private String dob;
	@Column(name = "Joining_Date")
	private String joining_date;
	@Column(name = "Mobile", nullable = false)
	private long empMobile;
	@Column(name = "Email_Id")
	private String empEmail;
	@Column(name = "Address", nullable = false)
	private String empAddress;
	@Column(name = "Designation")
	private String designation;
	@Column(name = "Salary")
	private long salary;
	@Column(name = "Bank_Name")
	private String bankName;
	@Column(name = "Account_Number")
	private long accountNumber;
	@Column(name = "IFSC_CODE")
	private String ifscCode;
	@Column(name = "Branch")
	private String branch;
	@Column(name = "Exit_date")
	private String exist_date;
}
