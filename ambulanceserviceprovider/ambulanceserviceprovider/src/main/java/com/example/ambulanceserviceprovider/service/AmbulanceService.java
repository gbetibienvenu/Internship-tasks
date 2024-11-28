package com.example.ambulanceserviceprovider.service;

import com.example.ambulanceserviceprovider.model.Ambulance;
import com.example.ambulanceserviceprovider.repository.AmbulanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmbulanceService {
    @Autowired
    private AmbulanceRepository ambulanceRepository;

    public Ambulance createAmbulance(HttpStatus ambulance) {
        return ambulanceRepository.save(ambulance);
    }

    public List<Ambulance> getAllAmbulances() {
        return ambulanceRepository.findAll();
    }

    public Ambulance getAmbulanceByLicensePlate(String licensePlate) {
        return ambulanceRepository.findByLicensePlate(licensePlate);
    }

    // Other service methods
}