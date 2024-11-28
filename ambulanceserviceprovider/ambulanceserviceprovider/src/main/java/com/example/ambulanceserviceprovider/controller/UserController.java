package com.example.ambulanceserviceprovider.controller;

import com.example.ambulanceserviceprovider.model.User;
import com.example.ambulanceserviceprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser (user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Other endpoints for user management
}