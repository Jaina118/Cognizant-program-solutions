package com.cognizant.orm_learn.model.quiz;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "attempt")
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "attempted_date")
    private LocalDateTime attemptedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "attempt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AttemptQuestion> attemptQuestions;
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDateTime getAttemptedDate() { return attemptedDate; }
    public void setAttemptedDate(LocalDateTime attemptedDate) { this.attemptedDate = attemptedDate; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<AttemptQuestion> getAttemptQuestions() { return attemptQuestions; }
    public void setAttemptQuestions(List<AttemptQuestion> attemptQuestions) { this.attemptQuestions = attemptQuestions; }
}