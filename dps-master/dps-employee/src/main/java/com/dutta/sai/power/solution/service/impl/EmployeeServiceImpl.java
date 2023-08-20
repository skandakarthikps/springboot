/**
 * 
 */

package com.dutta.sai.power.solution.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dutta.sai.power.solution.entity.Employee;
import com.dutta.sai.power.solution.repository.EmployeeRespository;
import com.dutta.sai.power.solution.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRespository repo;

	@Override
	public List<Employee> getAllEmployee() {

		return repo.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {

		return repo.findById(id).get();
	}

	@Override
	public Employee insertEmployee(Employee emp) {

		return repo.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) {

		return repo.save(emp);
	}

	@Override
	public void DeleteEmployee(long id) {

		repo.deleteById(id);
	}
}
