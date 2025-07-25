package com.cognizant.orm_learn;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

   
    private static CountryService countryService;

    public static void main(String[] args) throws CountryNotFoundException {
       
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        
        countryService = context.getBean(CountryService.class);

        testGetAllCountries();
        
        testFindCountryByCode();
        
        testAddCountry();
        
        testUpdateCountry();
        
        testDeleteCountry();

    }
    
    
    //To get all countries
    private static void testGetAllCountries() {
        LOGGER.info("Start");

        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);

        LOGGER.info("End");
    }
    
    //To find country by country code
    private static void testFindCountryByCode() throws CountryNotFoundException {
        LOGGER.info("Start");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country: {}", country);
        LOGGER.info("End");
    }
    
    //Add a New Country
    private static void testAddCountry() throws CountryNotFoundException {
        LOGGER.info("Start");

        Country country = new Country();
        country.setCode("ZZ");
        country.setName("Zootopia");

        countryService.addCountry(country);

        Country addedCountry = countryService.findCountryByCode("ZZ");
        LOGGER.debug("Added Country: {}", addedCountry);

        LOGGER.info("End");
    }
    
    //Update a Country
    private static void testUpdateCountry() throws CountryNotFoundException {
        LOGGER.info("Start");

        countryService.updateCountry("ZZ", "Updated Zootopia");

        Country updatedCountry = countryService.findCountryByCode("ZZ");
        LOGGER.debug("Updated Country: {}", updatedCountry);

        LOGGER.info("End");
    }

    //Delete a country
    private static void testDeleteCountry() {
        LOGGER.info("Start");

        countryService.deleteCountry("ZZ");
        LOGGER.debug("Deleted country with code ZZ");

        LOGGER.info("End");
    }
}