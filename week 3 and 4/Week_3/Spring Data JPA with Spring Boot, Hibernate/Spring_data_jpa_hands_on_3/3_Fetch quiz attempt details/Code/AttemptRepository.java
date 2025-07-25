package com.cognizant.orm_learn.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cognizant.orm_learn.model.quiz.Attempt;

public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    @Query("SELECT DISTINCT a FROM Attempt a "
         + "JOIN FETCH a.user "
         + "JOIN FETCH a.attemptQuestions aq "
         + "JOIN FETCH aq.question q "
         + "JOIN FETCH q.options "
         + "JOIN FETCH aq.attemptOptions ao "
         + "JOIN FETCH ao.option o "
         + "WHERE a.user.id = :userId AND a.id = :attemptId")
    Attempt getAttempt(int userId, int attemptId);
}