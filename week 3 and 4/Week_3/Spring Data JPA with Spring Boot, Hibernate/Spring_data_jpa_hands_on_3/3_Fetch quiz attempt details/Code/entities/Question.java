package com.cognizant.orm_learn.model.quiz;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;

    private double score;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Option> options = new HashSet<>();

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    public Set<Option> getOptions() { return options; }
    public void setOptions(Set<Option> options) { this.options = options; }
}