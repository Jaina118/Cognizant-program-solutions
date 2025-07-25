package com.cognizant.orm_learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.orm_learn.model.Department;
import com.cognizant.orm_learn.repository.Department_Payroll_Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class Department_Payroll_Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Department_Payroll_Service.class);

    @Autowired
    private Department_Payroll_Repository department_payroll_Repository;

    @Transactional
    public Department get(int id) {
        LOGGER.info("Start");
        return department_payroll_Repository.findById(id).get();
    }

    @Transactional
    public void save(Department department) {
        LOGGER.info("Start");
        department_payroll_Repository.save(department);
        LOGGER.info("End");
    }
}
