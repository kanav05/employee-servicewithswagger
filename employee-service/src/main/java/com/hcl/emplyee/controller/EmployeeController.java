package com.hcl.emplyee.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.emplyee.dto.EmployeeDto;
import com.hcl.emplyee.entity.Employee;
import com.hcl.emplyee.exceptions.ResourceNotFoundException;
import com.hcl.emplyee.request.EmployeeRequest;
import com.hcl.emplyee.response.EmployeeResponse;
import com.hcl.emplyee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")

public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;
	
	
	@ApiOperation(value = "View a list of available products",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@PostMapping(consumes ={ 
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE},
		produces = {
		MediaType.APPLICATION_XML_VALUE,
		MediaType.APPLICATION_JSON_VALUE})

	@RequestMapping("/")
	public ResponseEntity<EmployeeResponse> createEmployee(@Validated @RequestBody EmployeeRequest employeeRequest){
		LOGGER.info("Employee add: {}", employeeRequest);
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		EmployeeDto employeeDto = modelMapper.map(employeeRequest, EmployeeDto.class);
		EmployeeDto createEmployee = employeeService.creatgeEmployee(employeeDto);
		EmployeeResponse employeeResponse = modelMapper.map(createEmployee, EmployeeResponse.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);
		
	}
	
	@GetMapping
	@RequestMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		
		return employeeService.getAllEmployees();
	}
	
	
	@GetMapping(consumes ={ 
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE},
		produces = {
		MediaType.APPLICATION_XML_VALUE,
		MediaType.APPLICATION_JSON_VALUE})
	 @ApiOperation(value = "Search a Employee with an ID",response = Employee.class)
	@RequestMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		LOGGER.info("Employee find: id={}", id);

		Employee employee= employeeService.findById(id);
		
		return ResponseEntity.ok().body(employee);
	
	}
	
	@PutMapping
	@ApiOperation(value = "Update a employee")
    @RequestMapping(value = "/update/{id}")//, method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<EmployeeResponse> updateProduct(@PathVariable Integer id, @RequestBody EmployeeRequest employeeRequest) throws ResourceNotFoundException{
		LOGGER.info("Employee update", id);
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		EmployeeDto employeeDto = modelMapper.map(employeeRequest, EmployeeDto.class);
		Employee createEmployee = employeeService.findById(id);
		createEmployee.setName(employeeRequest.getName());
		createEmployee.setMobile(employeeRequest.getMobile());
		createEmployee.setEmpId(employeeRequest.getEmail());
		//createEmployee.setDob((employeeRequest.getDob());
		EmployeeResponse employeeResponse = modelMapper.map(createEmployee, EmployeeResponse.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);
		//Employee newEmp = new Employee();
        //Product storedProduct = productService.getProductById(id);
        //storedProduct.setDescription(product.getDescription());
        //storedProduct.setImageUrl(product.getImageUrl());
        //storedProduct.setPrice(product.getPrice());
        //productService.saveProduct(storedProduct);
        //return new ResponseEntity("Product updated successfully", HttpStatus.OK);
    }
}
