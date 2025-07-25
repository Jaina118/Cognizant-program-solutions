package com.cognizant.orm_learn.model.quiz;

import jakarta.persistence.*;

import java.util.HashSet;

import java.util.Set;

@Entity
@Table(name = "attempt_question")
public class AttemptQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attempt_id")
    private Attempt attempt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;
    
    @OneToMany(mappedBy = "attemptQuestion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<AttemptOption> attemptOptions = new HashSet<>();
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Attempt getAttempt() { return attempt; }
    public void setAttempt(Attempt attempt) { this.attempt = attempt; }

    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }

    public Set<AttemptOption> getAttemptOptions() { return attemptOptions; }
    public void setAttemptOptions(Set<AttemptOption> attemptOptions) { this.attemptOptions = attemptOptions; }
}