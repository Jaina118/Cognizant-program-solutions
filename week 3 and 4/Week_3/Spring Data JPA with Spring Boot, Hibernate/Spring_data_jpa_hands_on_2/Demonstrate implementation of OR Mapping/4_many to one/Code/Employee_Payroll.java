package com.cognizant.orm_learn.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee_Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary", columnDefinition = "DECIMAL(10,2)")
    private BigDecimal salary;

    @Column(name = "permanent")
    private boolean permanent;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id") // Foreign key
    private Department department;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }
    public void setSalary(BigDecimal i) {
        this.salary = i;
    }

    public boolean isPermanent() {
        return permanent;
    }
    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
                + ", dateOfBirth=" + dateOfBirth + "]";
    }
}

