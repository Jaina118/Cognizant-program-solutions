package com.cognizant.spring_learn;

import com.cognizant.spring_learn.Country;
import java.util.List;
import java.util.Optional;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    public Country getCountry(String code) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countryList = (List<Country>) context.getBean("countryList");

        Optional<Country> countryOptional = countryList.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst();

        if (countryOptional.isPresent()) {
            return countryOptional.get();
        } else {
            throw new Exception("Country not found for code: " + code);
        }
    }
}