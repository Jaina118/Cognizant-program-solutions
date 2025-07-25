package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "skillList")
    private Set<Employee_Payroll> employeeList;

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<Employee_Payroll> getEmployeeList() { return employeeList; }
    public void setEmployeeList(Set<Employee_Payroll> employeeList) { this.employeeList = employeeList; }

    @Override
    public String toString() {
        return "Skill [id=" + id + ", name=" + name + "]";
    }
}
