package com.cognizant.orm_learn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.EmployeeService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class EmployeeApplication {
	 private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeApplication.class);
	
	 @Autowired
	 private  EmployeeService employeeService;
	
	 public static void main(String[] args) {
	       
	        ApplicationContext context = SpringApplication.run(EmployeeApplication.class, args);
	        LOGGER.info("Inside main");
	        
	        //employeeService = context.getBean(EmployeeService.class);
	        
//	        testAddEmployee();
//	        testGetAllPermanentEmployees();
	        EmployeeApplication app = context.getBean(EmployeeApplication.class);
	        app.testGetAverageSalary();
}
	 
	    public void run(String... args) throws Exception {
	        double avgSalary = employeeService.getAverageSalary(1); // Replace 1 with actual dept ID
	        System.out.println("Average salary for department 1: " + avgSalary);
	    }
	    
	    @PostConstruct
	    public  void testGetAverageSalary() {
	        int deptId = 1; // replace with actual department id
	        Double avgSalary = employeeService.getAverageSalary(deptId);
	        System.out.println("Average Salary for Department ID " + deptId + ": " + avgSalary);
	    }

//	 public static void testGetAllPermanentEmployees() {
//		    LOGGER.info("Start");
//		    List<Employee> employees = employeeService.getAllPermanentEmployees();
//		    LOGGER.debug("Permanent Employees: {}", employees);
//		    employees.forEach(e -> {
//		        if (e.getSkillList().isEmpty()) {
//		            LOGGER.debug("No Skills assigned to employee: {}", e.getName());
//		        } else {
//		            LOGGER.debug("Skills: {}", e.getSkillList());
//		        }		    
//		        LOGGER.info("End");
//		        });
//		}
//	 
//
//private static void testAddEmployee() {
//    LOGGER.info("Start");
//
//    Employee employee = new Employee();
//    employee.setName("Meera");
//    employee.setSalary(70000.0);
//
//    employeeService.addEmployee(employee);
//
//    LOGGER.debug("Added Employee: {}", employee);
//
//    LOGGER.info("End");
//}
}