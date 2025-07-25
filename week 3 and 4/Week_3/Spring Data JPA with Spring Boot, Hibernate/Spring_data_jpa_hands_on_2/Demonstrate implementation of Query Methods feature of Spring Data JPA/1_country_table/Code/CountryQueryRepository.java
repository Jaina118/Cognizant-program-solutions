package com.cognizant.orm_learn.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.orm_learn.model.Country;

@Repository
public interface CountryQueryRepository extends JpaRepository<Country, String> {

    // Find countries where name contains a text (case-insensitive)
    List<Country> findByNameContainingIgnoreCase(String text);

    // Find countries where name contains text (ascending)
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String text);

    // Find countries starting with a specific letter (case-insensitive)
    List<Country> findByNameStartingWithIgnoreCase(String prefix);
}