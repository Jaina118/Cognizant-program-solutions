package com.cognizant.orm_learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.orm_learn.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Fetch permanent employees
    @Query("SELECT e FROM Employee e WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();
}
