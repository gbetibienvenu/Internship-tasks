package com.example.ambulanceserviceprovider.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.spi.Status;

@Getter
@Setter
@Entity
@Table(name = "ambulances")
public class Ambulance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String licensePlate;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private User driver;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(length = 255)
    private String location;

    @Column(length = 50)  // Add this line to declare the model field
    private String model;  // Add this field for the model of the ambulance

    // Constructors, getters, setters, etc.
    public Ambulance() {
    }

    // Optionally, a method for handling other logic
    public void series(String seriesInfo) {
        // Logic for handling series (e.g., vehicle series information)
    }
}



//package com.example.ambulanceserviceprovider.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.engine.spi.Status;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "ambulances")
//public class Ambulance {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, unique = true, length = 20)
//    private String licensePlate;
//
//    @ManyToOne
//    @JoinColumn(name = "driver_id", nullable = false)
//    private User driver;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Status status;
//
//    @Column(length = 255)
//    private String location;
//
//    // Constructors, getters, setters, etc.
//    public Ambulance() {
//    }
//
//    // Optionally, a method for handling other logic
//    public void series(String seriesInfo) {
//        // Logic for handling series
//    }
//}












//package com.example.ambulanceserviceprovider.model;
//
//import jakarta.persistence.*;
//import org.hibernate.engine.spi.Status;
//
//@Entity
//@Table(name = "ambulances")
//public class Ambulance {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, unique = true, length = 20)
//    private String licensePlate;
//
//    @ManyToOne
//    @JoinColumn(name = "driver_id")
//    private User driver;
//
//    @Enumerated(EnumType.STRING)
//    private Status status;
//
//    @Column(length = 255)
//    private String location;
//
//    public void series(String s) {
//    }
//
//    // Getters and Setters
//}