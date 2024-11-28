package com.example.ambulanceserviceprovider.model;

import jakarta.persistence.*;
import org.hibernate.engine.spi.Status;

@Entity
@Table(name = "ambulances")
public class Ambulance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String licensePlate;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private User driver;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(length = 255)
    private String location;

    public void series(String s) {
    }

    // Getters and Setters
}