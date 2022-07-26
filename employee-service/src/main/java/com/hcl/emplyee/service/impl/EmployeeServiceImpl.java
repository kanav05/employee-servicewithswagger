package com.hcl.emplyee.service.impl;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.emplyee.dto.EmployeeDto;
import com.hcl.emplyee.entity.Employee;
import com.hcl.emplyee.exceptions.ResourceNotFoundException;
import com.hcl.emplyee.repository.EmployeeRepository;
import com.hcl.emplyee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeRepository employeeRepository;
	//private ModelMapper modelMapper;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository){
		
		this.employeeRepository = employeeRepository;
		//this.modelMapper = mapper;
	}

	@Override
	public EmployeeDto creatgeEmployee(EmployeeDto empployeeDto) {
		//Date cdate = new Date();
		if(empployeeDto.getEmpId()==null){
		empployeeDto.setEmpId(UUID.randomUUID().toString());
		}
		
		//DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");

		//String dateInString =  userDetails.getDob(); // "07/06/2013 10:11:59";
		//DateTime dateTime = DateTime.parse(dateInString, formatter);
		//DateTime dateTimeWithZone = dateTime.withZone(DateTimeZone.forID("Asia/Kolkata"));

		Date cDate = new Date();
		
	    //LocalDateTime createDate = LocalDateTime.now();
		empployeeDto.setCreateDate(cDate);
	//	empployeeDto.setCreateDate(cdate);
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Employee employee = modelMapper.map(empployeeDto, Employee.class);
		employeeRepository.save(employee);
		
		EmployeeDto empResponse  = modelMapper.map(employee, EmployeeDto.class);
		return empResponse;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}
	

	public Employee findById(long id) throws ResourceNotFoundException {
		
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		return employee;
		
	}


}
