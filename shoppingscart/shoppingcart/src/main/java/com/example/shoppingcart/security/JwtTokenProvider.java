package com.example.shoppingcart.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationMs}")
    private int jwtExpirationMs;

    private Key getSigningKey() {
        // Use `Keys.hmacShaKeyFor()` to create a key from the secret with appropriate length
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    // Generate JWT token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)  // Store username as the subject
                .setIssuedAt(new Date())  // Set the current time as issued time
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))  // Set expiration time
                .signWith(getSigningKey(), SignatureAlgorithm.HS512)  // Sign the token with HS512 algorithm and secret key
                .compact();
    }

    // Validate JWT token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())  // Use the signing key for parsing
                    .build()
                    .parseClaimsJws(token);  // Parse and validate the token
            return true;
        } catch (Exception e) {
            return false;  // Invalid token
        }
    }

    // Extract username from JWT token
    public String getUsernameFromJwt(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String createToken(String username) {
        return username;
    }
}