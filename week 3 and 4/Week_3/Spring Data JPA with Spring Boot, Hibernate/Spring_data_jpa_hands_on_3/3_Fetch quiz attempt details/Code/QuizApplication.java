package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.quiz.Attempt;
import com.cognizant.orm_learn.service.AttemptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class QuizApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuizApplication.class);

    private static AttemptService attemptService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(QuizApplication.class, args);
        attemptService = context.getBean(AttemptService.class);
        getAttemptDetails();
    }

    private static void getAttemptDetails() {
        LOGGER.info("Start");
        Attempt attempt = attemptService.getAttempt(1, 1); // userId=1, attemptId=1

        LOGGER.info("User: {}", attempt.getUser().getUsername());
        LOGGER.info("Attempted Date: {}", attempt.getAttemptedDate());

        attempt.getAttemptQuestions().forEach(aq -> {
            LOGGER.info("Q: {}", aq.getQuestion().getText());
            aq.getAttemptOptions().forEach(ao -> {
                LOGGER.info("Option: {}  Score: {}  Selected: {}",
                        ao.getOption().getText(),
                        aq.getQuestion().getScore(),
                        ao.isSelected());
            });
        });
        LOGGER.info("End");
    }
}
