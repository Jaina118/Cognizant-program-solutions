package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.Base64;

@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    // Endpoint to generate JWT
    @GetMapping("/authenticate")
    public TokenResponse authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START authenticate()");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new RuntimeException("Missing or invalid Authorization header");
        }

        // Decode username:password 
        String base64Credentials = authHeader.substring("Basic".length()).trim();
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decodedBytes);
        String[] values = credentials.split(":", 2);
        String username = values[0];
        String password = values[1];

        LOGGER.debug("Username: {}", username);
        LOGGER.debug("Password: {}", password);

        // Validate username & password
        if (!"user".equals(username) || !"pwd".equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }

        // Generate JWT token
        String token = JwtUtil.generateToken(username);

        LOGGER.info("END authenticate()");
        return new TokenResponse(token);
    }

    static class TokenResponse {
        private String token;

        public TokenResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
