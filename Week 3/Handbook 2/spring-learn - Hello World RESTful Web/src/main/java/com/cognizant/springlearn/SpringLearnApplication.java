package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Starting SpringLearnApplication main method...");
        
        // Bootstraps the entire Spring Boot Application environment
        SpringApplication.run(SpringLearnApplication.class, args);
        
        LOGGER.info("SpringLearnApplication context started successfully!");

        // Execute the Spring Core Homework requirement to load bean data from XML
        displayCountry();
    }

    /**
     * Reads the country bean setup from country.xml and displays the details.
     */
    public static void displayCountry() {
        LOGGER.info("--- Initializing ApplicationContext for XML parsing ---");
        
        // Instantiates the container and eagerly loads definitions inside country.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        LOGGER.info("--- Requesting single country bean from context ---");
        Country country = context.getBean("country", Country.class);
        
        // Logs out the final mapping using the custom toString representation
        LOGGER.debug("Country details fetched from XML context: {}", country.toString());
    }
}