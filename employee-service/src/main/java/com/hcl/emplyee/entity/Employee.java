package com.hcl.emplyee.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@Table(name="employee")
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Employee implements Serializable {

	private static final long serialVersionUID = 7584704225299914562L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @ApiModelProperty(notes = "The application-specific Employee ID")
	private long id;
	@Column(name="emp_id", unique=true)
	private String empId;
	@Column(name="name",length=30, nullable =false)
	private String name;
	@Column(name="email",length=50,unique=true, nullable =false)
	private String email;
	@Column(name="mobile",length=13,unique=true, nullable =false)
	private String mobile;
	@Column(name="address",length=200, nullable =false)
	private String address;
	
	 		
	@Column(name="dob",length=30)
	@Temporal(value = TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dob;
	@Column(name="create_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createDate ;
	
	

}
