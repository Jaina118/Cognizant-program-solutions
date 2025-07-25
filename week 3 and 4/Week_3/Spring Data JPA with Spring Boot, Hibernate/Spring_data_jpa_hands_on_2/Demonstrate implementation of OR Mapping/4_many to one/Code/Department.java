package com.cognizant.orm_learn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    
    @ManyToOne
    @JoinColumn(name = "employee_id") // foreign key 
    private Employee_Payroll employee;

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Employee_Payroll getEmployee() { return employee; }
    public void setEmployee(Employee_Payroll employee) { this.employee = employee; }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + ", employee=" + employee + "]";
    }
}
