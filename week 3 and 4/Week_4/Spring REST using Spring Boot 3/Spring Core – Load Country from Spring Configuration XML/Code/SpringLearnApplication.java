package com.cognizant.spring_learn;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START Main");
        displayCountry();
        LOGGER.info("END Main");
    }

    public static void displayCountry() {
        LOGGER.info("START displayCountry()");

        // Load Spring context from XML
        ApplicationContext c = new ClassPathXmlApplicationContext("country.xml");

        // Retrieve the country bean
        Country country = c.getBean("country", Country.class);

        // Print country details
        LOGGER.info("Country: {}", country.toString());

        LOGGER.info("END displayCountry()");
    }
}