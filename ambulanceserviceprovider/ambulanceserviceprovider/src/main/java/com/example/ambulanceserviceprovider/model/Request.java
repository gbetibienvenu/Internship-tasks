package com.example.ambulanceserviceprovider.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Assuming User is a valid entity class

    @ManyToOne
    @JoinColumn(name = "ambulance_id", nullable = false)
    private Ambulance ambulance; // Assuming Ambulance is a valid entity class

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus status; // Use the custom Status enum

    @Column(nullable = false, length = 255)
    private String pickupLocation;

    @Column(nullable = false, length = 255)
    private String dropLocation;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @Column(nullable = false, length = 255)
    private String details;

    // No-argument constructor
    public Request() {
        this.createdAt = new Timestamp(System.currentTimeMillis()); // Automatically set createdAt
    }
}







//package com.example.ambulanceserviceprovider.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.engine.spi.Status;
//
//import java.sql.Timestamp;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "requests")
//public class Request {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "ambulance_id", nullable = false)
//    private Ambulance ambulance;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Status status;
//
//    @Column(nullable = false, length = 255)
//    private String pickupLocation;
//
//    @Column(nullable = false, length = 255)
//    private String dropLocation;
//
//    @Column(name = "created_at", nullable = false, updatable = false)
//    private Timestamp createdAt;
//
//    @Column(nullable = false, length = 255)
//    private String details;
//
//    // Constructors, getters, setters, etc.
//    public Request() {
//    }
//}










//package com.example.ambulanceserviceprovider.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.engine.spi.Status;
//import java.security.Timestamp;
//
//@Setter
//@Getter
//@Entity
//@Table(name = "requests")
//public class Request {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "ambulance_id")
//    private Ambulance ambulance;
//
//    @Enumerated(EnumType.STRING)
//    private Status status;
//
//    @Column(nullable = false, length = 255)
//    private String pickupLocation;
//
//    @Column(nullable = false, length = 255)
//    private String dropLocation;
//
//    @Column(name = "created_at", nullable = false, updatable = false)
//    private Timestamp createdAt;
//
//    // Getter and Setter for 'details'
//    @Getter
//    @Setter
//    @Column(nullable = false, length = 255)
//    private String details;
//
//}