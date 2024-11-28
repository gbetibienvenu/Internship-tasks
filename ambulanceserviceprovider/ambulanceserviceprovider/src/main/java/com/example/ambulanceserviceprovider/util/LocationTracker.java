package com.example.ambulanceserviceprovider.util;

import org.springframework.stereotype.Service;

@Service
public class LocationTracker {
    public String getCurrentLocation(Long ambulanceId) {
        // Logic to track ambulance location
        return "Current Location";
    }
}