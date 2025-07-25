package com.cognizant.orm_learn.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryQueryRepository;

@Service
public class CountryQueryService {

    @Autowired
    private CountryQueryRepository countryQueryRepository;

    public List<Country> searchCountriesByName(String text) {
        return countryQueryRepository.findByNameContainingIgnoreCase(text);
    }

    public List<Country> searchCountriesByNameSorted(String text) {
        return countryQueryRepository.findByNameContainingIgnoreCaseOrderByNameAsc(text);
    }

    public List<Country> getCountriesByStartingLetter(String letter) {
        return countryQueryRepository.findByNameStartingWithIgnoreCase(letter);
    }
}
