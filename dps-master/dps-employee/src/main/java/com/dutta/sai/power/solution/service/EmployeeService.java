
package com.dutta.sai.power.solution.service;

import java.util.List;

import com.dutta.sai.power.solution.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployee();

	public Employee getEmployeeById(long id);

	public Employee insertEmployee(Employee emp);

	public Employee updateEmployee(Employee emp);

	public void DeleteEmployee(long id);
}
