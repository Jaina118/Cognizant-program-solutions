package com.cognizant.orm_learn.model.quiz;


import jakarta.persistence.*;

@Entity
public class AttemptOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean selected;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attempt_question_id")
    private AttemptQuestion attemptQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_id")
    private Option option;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public boolean isSelected() { return selected; }
    public void setSelected(boolean selected) { this.selected = selected; }

    public AttemptQuestion getAttemptQuestion() { return attemptQuestion; }
    public void setAttemptQuestion(AttemptQuestion attemptQuestion) { this.attemptQuestion = attemptQuestion; }

    public Option getOption() { return option; }
    public void setOption(Option option) { this.option = option; }
}