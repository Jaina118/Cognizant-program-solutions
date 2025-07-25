package com.cognizant.orm_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.cognizant.orm_learn")
public class PayrollApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayrollApplication.class, args);
    }
}
