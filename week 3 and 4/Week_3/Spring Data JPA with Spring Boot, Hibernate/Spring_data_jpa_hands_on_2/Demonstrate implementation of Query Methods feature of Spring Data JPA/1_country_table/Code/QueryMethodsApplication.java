package com.cognizant.orm_learn;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryQueryService;

@SpringBootApplication
public class QueryMethodsApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryMethodsApplication.class);

    private static CountryQueryService countryQueryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(QueryMethodsApplication.class, args);
        countryQueryService = context.getBean(CountryQueryService.class);

        testSearchCountriesByName();
        testSearchCountriesByNameSorted();
        testGetCountriesByStartingLetter();
    }

    private static void testSearchCountriesByName() {
        LOGGER.info("Start searchCountriesByName");
        List<Country> countries = countryQueryService.searchCountriesByName("ou");
        countries.forEach(country -> LOGGER.info("{}", country));
        LOGGER.info("End searchCountriesByName");
    }

    private static void testSearchCountriesByNameSorted() {
        LOGGER.info("Start searchCountriesByNameSorted");
        List<Country> countries = countryQueryService.searchCountriesByNameSorted("ou");
        countries.forEach(country -> LOGGER.info("{}", country));
        LOGGER.info("End searchCountriesByNameSorted");
    }

    private static void testGetCountriesByStartingLetter() {
        LOGGER.info("Start getCountriesByStartingLetter");
        List<Country> countries = countryQueryService.getCountriesByStartingLetter("Z");
        countries.forEach(country -> LOGGER.info("{}", country));
        LOGGER.info("End getCountriesByStartingLetter");
    }
}