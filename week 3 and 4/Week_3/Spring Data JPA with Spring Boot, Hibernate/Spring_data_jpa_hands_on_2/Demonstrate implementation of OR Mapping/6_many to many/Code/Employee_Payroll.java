package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee_Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private BigDecimal salary;
    private boolean permanent;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(fetch = FetchType.EAGER) 
    @JoinTable(
        name = "employee_skill",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skillList;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getSalary() { return salary; }
    public void setSalary(BigDecimal salary) { this.salary = salary; }

    public boolean isPermanent() { return permanent; }
    public void setPermanent(boolean permanent) { this.permanent = permanent; }

    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public Set<Skill> getSkillList() { return skillList; }
    public void setSkillList(Set<Skill> skillList) { this.skillList = skillList; }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }
}
