package com.cognizant.orm_learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.orm_learn.model.Skill;
import com.cognizant.orm_learn.repository.Skill_Payroll_Repository;

@Service
public class Skill_Service {

    @Autowired
    private Skill_Payroll_Repository skill_payroll_Repository;

    @Transactional
    public Skill get(int id) {
        return skill_payroll_Repository.findById(id).orElseThrow(
            () -> new RuntimeException("Skill with id " + id + " not found")
        );
    }
}
