package com.hcl.emplyee;


import lombok.Data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Data
@SpringBootApplication
// http://localhost:8080/swagger-ui.html
//http://localhost:8085/v2/api-docs

//@EnableSwagger2
/*@OpenAPIDefinition(info =
	@Info(title = "Employee API", version = "1.0", description = "Documentation Employee API v1.0")
)*/


public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
		
		System.out.println("Hello");
	}
	
	
	/*@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.hcl.emplyee.controller"))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Employee API").description("Documentation Employee API v1.0").build());
	}*/

}
