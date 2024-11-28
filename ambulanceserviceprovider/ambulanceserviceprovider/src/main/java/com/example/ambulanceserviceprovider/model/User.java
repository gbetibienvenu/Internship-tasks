package com.example.ambulanceserviceprovider.model;

import jakarta.persistence.*;

import javax.management.relation.Role;
import java.security.Timestamp;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(length = 15)
    private String phoneNumber;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    public void setName(String johnDoe) {
    }

    public void setEmail(String mail) {
    }

    public void setPassword(String password) {
    }

    public void setRole(String user) {
    }

    // Getters and Setters
}