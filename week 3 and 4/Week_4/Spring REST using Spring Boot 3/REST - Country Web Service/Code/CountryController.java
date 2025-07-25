package com.cognizant.spring_learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.Country;

@RestController
public class CountryController {
	 private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	 

	   @RequestMapping(value = "/country", method = RequestMethod.GET)
	    public Country getCountryIndia() {
	        LOGGER.info("START getCountryIndia()");

	        // Load Spring XML configuration
	        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

	        // Get the 'country' bean
	        Country country = context.getBean("country", Country.class);

	        LOGGER.info("END getCountryIndia()");
	        return country; 
	    }
	}