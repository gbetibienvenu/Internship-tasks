package com.example.shoppingcart.controller;

import com.example.shoppingcart.dto.LoginRequest;
import com.example.shoppingcart.model.User;
import com.example.shoppingcart.model.JwtAuthenticationResponse;
import com.example.shoppingcart.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;  // Add this import

@Slf4j  // Lombok annotation that generates a logger
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        return authService.registerUser(user);  // Call the service to handle user registration
    }

    // Login and generate JWT token
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        log.debug("Attempting login for user: {}", loginRequest.getUsername());
        try {
            String jwt = String.valueOf(authService.authenticateUser(loginRequest));
            log.debug("Login successful for user: {}", loginRequest.getUsername());
            return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
        } catch (Exception e) {
            log.error("Login error for user: {}", loginRequest.getUsername(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("You are getting this things wrong ooh bro wale please ");
        }
    }
}











//package com.example.shoppingcart.controller;
//
//import com.example.shoppingcart.dto.LoginRequest;
//import com.example.shoppingcart.model.JwtAuthenticationResponse;
//import com.example.shoppingcart.model.User;
//import com.example.shoppingcart.service.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private AuthService authService;
//
//    // Register a new user
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody User user) {
//        return authService.registerUser(user);  // Call the service to handle user registration
//    }
//
//    // Login and generate JWT token
//
//    @PostMapping("/login")
//    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
//        log.debug("Attempting login for user: {}", loginRequest.getUsername());
//        try {
//            String jwt = authService.authenticateUser(loginRequest);
//            log.debug("Login successful for user: {}", loginRequest.getUsername());
//            return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
//        } catch (Exception e) {
//            log.error("Login error for user: {}", loginRequest.getUsername(), e);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("An unexpected error occurred");
//        }
//    }
//
//
//
////    @PostMapping("/login")
////    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
////        return authService.authenticateUser(loginRequest);  // Call the service for login and JWT generation
////    }
//}