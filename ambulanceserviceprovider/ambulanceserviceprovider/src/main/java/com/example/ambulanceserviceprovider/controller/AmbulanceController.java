package com.example.ambulanceserviceprovider.controller;

import com.example.ambulanceserviceprovider.model.Ambulance;
import com.example.ambulanceserviceprovider.service.AmbulanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/ambulances")
public class AmbulanceController {
    @Autowired
    private AmbulanceService ambulanceService;

    @PostMapping
    public ResponseEntity<Ambulance> createAmbulance(@RequestBody Ambulance ambulance) {
        return ResponseEntity.ok(ambulanceService.createAmbulance(ambulance));
    }

    @GetMapping
    public ResponseEntity<List<Ambulance>> getAllAmbulances() {
        return ResponseEntity.ok(ambulanceService.getAllAmbulances());
    }

    // Other endpoints for ambulance management
}