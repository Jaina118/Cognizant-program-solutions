package com.cognizant.orm_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.orm_learn.model.Employee_Payroll;

public interface Employee_Payroll_Repository extends JpaRepository<Employee_Payroll, Integer> {
	
}
