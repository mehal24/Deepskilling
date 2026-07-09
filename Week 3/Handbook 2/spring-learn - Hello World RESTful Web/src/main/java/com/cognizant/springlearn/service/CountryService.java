package com.cognizant.springlearn.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.cognizant.springlearn.Country;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    @SuppressWarnings("unchecked")
    public Country getCountry(String code) {
        LOGGER.info("START: service layer searching for country code: {}", code);

        // Load the XML configuration context
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        // Retrieve the pre-populated arraylist bean
        ArrayList<Country> countries = (ArrayList<Country>) context.getBean("countryList");

        // Use modern Lambda/Stream API to filter case-insensitively
        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null); // Returns null if no country matches
    }
}