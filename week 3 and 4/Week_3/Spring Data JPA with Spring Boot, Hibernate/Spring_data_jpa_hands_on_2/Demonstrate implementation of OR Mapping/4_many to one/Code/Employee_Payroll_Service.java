package com.cognizant.orm_learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.orm_learn.model.Employee_Payroll;
import com.cognizant.orm_learn.repository.Employee_Payroll_Repository;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class Employee_Payroll_Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Employee_Payroll_Service.class);

    @Autowired
    private Employee_Payroll_Repository employee_Payroll_Repository;

    @Transactional
    public Employee_Payroll get(int id) {
        LOGGER.info("Start");

        return employee_Payroll_Repository.findById(id)
                .orElseGet(() -> {
                    // Print a few blank lines
                    
                    LOGGER.warn("Employee with id {} not found.", id);
                    System.out.println("\n\n\n");
                    throw new NoSuchElementException("Employee with id " + id + " not found.");
                });
    }


    @Transactional
    public void save(Employee_Payroll employee) {
        LOGGER.info("Start");
        employee_Payroll_Repository.save(employee);
        LOGGER.info("End");
    }
}
