package com.cognizant.orm_learn.model;


import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Double salary;
    
    @Column(name = "permanent")
    private boolean permanent;
    
    @ManyToMany(fetch = FetchType.EAGER) 
    @JoinTable(
        name = "employee_skill",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skillList;

    // Getter and Setter
    public Set<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(Set<Skill> skillList) {
        this.skillList = skillList;
    }


    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    
    public boolean isPermanent() {
        return permanent;
    }
    
    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}
