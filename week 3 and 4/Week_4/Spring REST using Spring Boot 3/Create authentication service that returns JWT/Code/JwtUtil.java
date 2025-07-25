package com.cognizant.spring_learn.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    // At least 256-bit key for HS256
    private static final Key SECRET_KEY = Keys.hmacShaKeyFor("mysupersecretkeymysupersecretkey123!".getBytes());

    public static String generateToken(String username) {
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + 1000 * 60 * 10)) // 10 min expiry
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }
}
