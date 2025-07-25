package com.cognizant.orm_learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;
    
    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountry(String code) {
        return countryRepository.findById(code).orElse(null);
    }
    
    //To find country by country code
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country with code " + countryCode + " not found.");
        }
        return result.get();
}
    
    //Add a New Country
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }
    
    //Update a Country
    @Transactional
    public void updateCountry(String code, String newName) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(code);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country with code " + code + " not found.");
        }
        Country country = result.get();
        country.setName(newName);
        countryRepository.save(country);
    }
    
    //Delete a Country
    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }



}
