package com.example.shoppingcart.service;

import com.example.shoppingcart.model.User;
import com.example.shoppingcart.repository.UserRepository;
import com.example.shoppingcart.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, JwtTokenProvider jwtTokenProvider, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    // Method to register a new user
    public User registerUser(User user) {
        // Check if user already exists
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("User already exists with username: " + user.getUsername());
        }

        // Encrypt the user's password
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        return userRepository.save(user); // Save the user to the database
    }

    // Method to authenticate user and generate JWT token
    public String loginUser(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Validate password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // Generate JWT token if credentials are valid
        return jwtTokenProvider.createToken(username);
    }

    // Method to find a user by username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }
}

