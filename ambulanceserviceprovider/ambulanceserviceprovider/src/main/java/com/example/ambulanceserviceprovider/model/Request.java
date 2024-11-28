package com.example.ambulanceserviceprovider.model;

import jakarta.persistence.*;
import org.hibernate.engine.spi.Status;
import java.security.Timestamp;

@Entity
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ambulance_id")
    private Ambulance ambulance;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false, length = 255)
    private String pickupLocation;

    @Column(nullable = false, length = 255)
    private String dropLocation;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    // Getters and Setters
}