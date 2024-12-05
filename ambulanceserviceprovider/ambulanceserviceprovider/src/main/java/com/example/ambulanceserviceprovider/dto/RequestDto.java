package com.example.ambulanceserviceprovider.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {
    private Long id;
    private Long userId;
    private Long ambulanceId;
    private String status;
    private String pickupLocation;
    private String dropLocation;

    // Getters and Setters
}