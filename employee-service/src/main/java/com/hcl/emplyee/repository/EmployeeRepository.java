package com.hcl.emplyee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.emplyee.dto.EmployeeDto;
import com.hcl.emplyee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	EmployeeDto findByEmail(String email);
	EmployeeDto findByEmpId(String empId);
	

}
