package com.cognizant.springlearn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
    
    // Generate a secure signing key for HS256 algorithm
    private final Key jwtKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @PostMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        LOGGER.info("START: Authentication process initialized.");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new RuntimeException("Missing or invalid Authorization header");
        }

        // 1. Extract and Decode Base64 from Header ("Basic dXNlcjpwd2Q=")
        String base64Credentials = authHeader.substring(6);
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decodedBytes, StandardCharsets.UTF_8);
        
        // credentials string is formatted as "username:password"
        String[] values = credentials.split(":", 2);
        String username = values[0];
        String password = values[1];

        LOGGER.info("Attempting login verification for user: {}", username);

        // 2. Validate user credentials (Hardcoded match for user:pwd as requested)
        if ("user".equals(username) && "pwd".equals(password)) {
            LOGGER.info("Credentials verified successfully. Generating token...");

            // 3. Generate JWT Token
            long nowMillis = System.currentTimeMillis();
            Date now = new Date(nowMillis);
            Date expiryDate = new Date(nowMillis + 1200000); // 20 Mins validity

            String jwtToken = Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(now)
                    .setExpiration(expiryDate)
                    .signWith(jwtKey)
                    .compact();

            Map<String, String> response = new HashMap<>();
            response.put("token", jwtToken);
            
            LOGGER.info("END: Authentication process complete. Token returned.");
            return response;
        } else {
            LOGGER.error("Authentication failed: Invalid username or password.");
            throw new RuntimeException("Invalid credentials provided.");
        }
    }
}