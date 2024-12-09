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

    // Create a new ambulance
    @PostMapping
    public ResponseEntity<Ambulance> createAmbulance(@RequestBody Ambulance ambulance) {
        Ambulance createdAmbulance = ambulanceService.createAmbulance(ambulance);
        return ResponseEntity.ok(createdAmbulance);
    }

    // Get a list of all ambulances
    @GetMapping
    public ResponseEntity<List<Ambulance>> getAllAmbulances() {
        List<Ambulance> ambulances = ambulanceService.getAllAmbulances();
        return ResponseEntity.ok(ambulances);
    }

    // Get a specific ambulance by ID
    @GetMapping("/{id}")
    public Ambulance getAmbulanceById(@PathVariable Long id) {
        Ambulance ambulance = ambulanceService.getAmbulanceById(id);
        return ResponseEntity.ok(ambulance).getBody();
    }

    // Update an existing ambulance
    @PutMapping("/{id}")
    public ResponseEntity<Ambulance> updateAmbulance(@PathVariable Long id, @RequestBody Ambulance ambulance) {
        Ambulance updatedAmbulance = ambulanceService.updateAmbulance(id, ambulance);
        return ResponseEntity.ok(updatedAmbulance);
    }

    // Delete an ambulance
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAmbulance(@PathVariable Long id) {
        ambulanceService.deleteAmbulance(id);
        return ResponseEntity.noContent().build();
    }
}







//package com.example.ambulanceserviceprovider.controller;
//
//import com.example.ambulanceserviceprovider.model.Ambulance;
//import com.example.ambulanceserviceprovider.service.AmbulanceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//        import java.util.List;
//
//@RestController
//@RequestMapping("/api/ambulances")
//public class AmbulanceController {
//    @Autowired
//    private AmbulanceService ambulanceService;
//
//    @PostMapping
//    public ResponseEntity<Ambulance> createAmbulance(@RequestBody Ambulance ambulance) {
//        return ResponseEntity.ok(ambulanceService.createAmbulance(ambulance));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Ambulance>> getAllAmbulances() {
//        return ResponseEntity.ok(ambulanceService.getAllAmbulances());
//    }
//
//    // Other endpoints for ambulance management
//}