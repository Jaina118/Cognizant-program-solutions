package com.cognizant.orm_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.EmployeeService;

@SpringBootApplication
public class EmployeeApplication {
	 private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeApplication.class);
	
	
	 private static EmployeeService employeeService;
	
	 public static void main(String[] args) {
	       
	        ApplicationContext context = SpringApplication.run(EmployeeApplication.class, args);
	        LOGGER.info("Inside main");
	        
	        employeeService = context.getBean(EmployeeService.class);
	        
	        testAddEmployee();
}

private static void testAddEmployee() {
    LOGGER.info("Start");

    Employee employee = new Employee();
    employee.setName("Meera");
    employee.setSalary(70000.0);

    employeeService.addEmployee(employee);

    LOGGER.debug("Added Employee: {}", employee);

    LOGGER.info("End");
}
}