
package com.dutta.sai.power.solution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dutta.sai.power.solution.entity.Employee;
import com.dutta.sai.power.solution.service.impl.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;

	@GetMapping("/allEmployees")
	public List<Employee> getAllEmployee() {

		return service.getAllEmployee();
	}

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee emp) {

		return service.insertEmployee(emp);
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployeeByID(@PathVariable("id") long id) {

		System.out.println("employee by id: " + service.getEmployeeById(id).toString());
		return service.getEmployeeById(id);
	}

	@PostMapping("/employee/update")
	public Employee updateEmployee(@RequestBody Employee emp) {

		return service.updateEmployee(emp);
	}

	@GetMapping("/employee/delete/{id}")
	public void deleteEmployee(@PathVariable("id") long id) {

		service.DeleteEmployee(id);
	}
}
