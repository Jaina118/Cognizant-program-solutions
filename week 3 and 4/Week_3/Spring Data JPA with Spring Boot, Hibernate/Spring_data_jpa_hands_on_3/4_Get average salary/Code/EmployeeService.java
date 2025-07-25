package com.cognizant.orm_learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

//    @Transactional
//    public void addEmployee(Employee employee) {
//        employeeRepository.save(employee);
//    }
//    
//    public List<Employee> getAllPermanentEmployees() {
//        return employeeRepository.getAllPermanentEmployees();
//    }
    
    public double getAverageSalary(int departmentId) {
        return employeeRepository.getAverageSalary(departmentId);
    }
}
