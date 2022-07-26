package com.hcl.emplyee.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmployeeRequest {
	
   //private long id;
	
	//private String empId;
	
	private String name;
	
	private String email;
	
	private String mobile;
	
	private String address;
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")

	private String dob;
	
	//private String createDate ;
	private String createDate;


}
