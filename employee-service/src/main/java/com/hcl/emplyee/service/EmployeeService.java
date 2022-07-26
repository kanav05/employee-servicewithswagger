package com.hcl.emplyee.service;

import java.util.List;

import com.hcl.emplyee.dto.EmployeeDto;
import com.hcl.emplyee.entity.Employee;
import com.hcl.emplyee.exceptions.ResourceNotFoundException;

public interface EmployeeService {
	
	EmployeeDto creatgeEmployee(EmployeeDto empployeeDto);
	List<Employee>  getAllEmployees();
	
	public Employee findById(long id) throws ResourceNotFoundException;

}
