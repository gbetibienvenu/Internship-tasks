package com.example.ambulanceserviceprovider.repository;

import com.example.ambulanceserviceprovider.model.Ambulance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmbulanceRepository extends JpaRepository<Ambulance, Long> {
    Ambulance findByLicensePlate(String licensePlate);
}