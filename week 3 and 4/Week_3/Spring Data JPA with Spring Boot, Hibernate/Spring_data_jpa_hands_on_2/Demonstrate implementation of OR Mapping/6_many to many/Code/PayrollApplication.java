package com.cognizant.orm_learn;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Department;
import com.cognizant.orm_learn.model.Employee_Payroll;
import com.cognizant.orm_learn.model.Skill;
import com.cognizant.orm_learn.service.Department_Payroll_Service;
import com.cognizant.orm_learn.service.Employee_Payroll_Service;
import com.cognizant.orm_learn.service.Skill_Service;

@SpringBootApplication(scanBasePackages = "com.cognizant.orm_learn")
public class PayrollApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayrollApplication.class);
    private static Employee_Payroll_Service employee_Payroll_Service;
    private static Department_Payroll_Service department_Payroll_Service;
    private static Skill_Service skillService;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(PayrollApplication.class, args);

        employee_Payroll_Service = context.getBean(Employee_Payroll_Service.class);
        department_Payroll_Service = context.getBean(Department_Payroll_Service.class);
        skillService = context.getBean(Skill_Service.class);

        testGetEmployee();
        //testAddEmployee();
        //testUpdateEmployee();
        //testGetDepartment();
          testAddSkillToEmployee(); 
    }

    private static void testGetEmployee() {
        LOGGER.info("==== Start: testGetEmployee ====");
        try {
            Employee_Payroll employee = employee_Payroll_Service.get(1);
            LOGGER.debug("Employee: {}", employee);
            LOGGER.debug("Department: {}", employee.getDepartment());
            LOGGER.debug("Skills: {}", employee.getSkillList());
        } catch (Exception e) {
            LOGGER.error("Error in testGetEmployee: {}", e.getMessage());
            System.out.println("\n\nCould not fetch employee: " + e.getMessage());
        }
        LOGGER.info("==== End: testGetEmployee ====\n");
    }

    private static void testAddEmployee() {
        LOGGER.info("==== Start: testAddEmployee ====");
        try {
            Employee_Payroll employee = new Employee_Payroll();
            employee.setName("John");
            employee.setSalary(BigDecimal.valueOf(50000));
            employee.setPermanent(true);
            employee.setDateOfBirth(new Date());

            Department dept = department_Payroll_Service.get(1); // Department with ID 1
            employee.setDepartment(dept);

            employee_Payroll_Service.save(employee);
            LOGGER.debug("Employee Added: {}", employee);
        } catch (Exception e) {
            LOGGER.error("Error in testAddEmployee: {}", e.getMessage());
            System.out.println("\n\nCould not add employee: " + e.getMessage());
        }
        LOGGER.info("==== End: testAddEmployee ====\n");
    }

    private static void testUpdateEmployee() {
    	
        LOGGER.info("==== Start: testUpdateEmployee ====");
        try {
            Employee_Payroll employee = employee_Payroll_Service.get(1); // Get an existing employee
            Department newDept = department_Payroll_Service.get(2); // Set to a different department

            employee.setDepartment(newDept);
            employee_Payroll_Service.save(employee);

            LOGGER.debug("Updated Employee: {}", employee);
            
        } catch (Exception e) {
            LOGGER.error("Error in testUpdateEmployee: {}", e.getMessage());
            System.out.println("\n\nCould not update employee: " + e.getMessage());
        }
        LOGGER.info("==== End: testUpdateEmployee ====\n");
    }
    
    private static void testGetDepartment() {
    	
        LOGGER.info("Start");
        
        Department dept = department_Payroll_Service.get(4);

        LOGGER.debug("Department: {}", dept);
        LOGGER.debug("Employees in Department:");

        dept.getEmployeeList().forEach(emp -> LOGGER.debug("Employee: {}", emp));

        LOGGER.info("End");
        
    }
    
    private static void testAddSkillToEmployee() {
        LOGGER.info("Start");

        Employee_Payroll employee = employee_Payroll_Service.get(1); 
        Skill skill = skillService.get(2);                  

        Set<Skill> skillList = employee.getSkillList();
        skillList.add(skill);                               
        employee.setSkillList(skillList);

        employee_Payroll_Service.save(employee);                    
        LOGGER.debug("Updated Employee with Skills: {}", employee.getSkillList());

        LOGGER.info("End");
    }
}
