package com.hcl.emplyee.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	
	private String empId;
	
	private String name;
	
	private String email;
	
	private String mobile;
	
	private String address;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date dob;
	@Temporal(value = TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date createDate ;

	
	

}
