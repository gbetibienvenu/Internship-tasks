package com.example.shoppingcart.service;

import com.example.shoppingcart.dto.LoginRequest;
import com.example.shoppingcart.model.User;
import com.example.shoppingcart.repository.UserRepository;
import com.example.shoppingcart.security.JwtTokenProvider;
import com.example.shoppingcart.model.JwtAuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    // Method to register a new user
    public ResponseEntity<?> registerUser(User user) {
        // Check if the username already exists
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username is already taken.");
        }

        // Encode the user's password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the new user in the repository
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully.");
    }

    // Method to authenticate an existing user and generate JWT token
    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
        // Fetch the user by username
        Optional<User> userOptional = userRepository.findByUsername(loginRequest.getUsername());

        // If the user exists and the password matches, generate a JWT token
        if (userOptional.isPresent() && passwordEncoder.matches(loginRequest.getPassword(), userOptional.get().getPassword())) {
            // Generate JWT token using the JwtTokenProvider
            String token = jwtTokenProvider.generateToken(userOptional.get().getUsername());

            // Return the token wrapped in a response body
            JwtAuthenticationResponse response = new JwtAuthenticationResponse(token);
            return ResponseEntity.ok(response);
        } else {
            // Return 401 if credentials are invalid
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
        }
    }
}