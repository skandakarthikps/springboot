
package com.dutta.sai.power.solution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dutta.sai.power.solution.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {
}
