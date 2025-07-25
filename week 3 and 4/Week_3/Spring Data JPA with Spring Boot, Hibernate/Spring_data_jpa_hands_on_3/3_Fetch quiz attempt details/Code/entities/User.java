package com.cognizant.orm_learn.model.quiz;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Attempt> attempts;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public List<Attempt> getAttempts() { return attempts; }
    public void setAttempts(List<Attempt> attempts) { this.attempts = attempts; }
}