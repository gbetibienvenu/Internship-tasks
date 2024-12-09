package com.example.ambulanceserviceprovider.controller;

import com.example.ambulanceserviceprovider.dto.RequestDto;
import com.example.ambulanceserviceprovider.model.Request;
import com.example.ambulanceserviceprovider.model.RequestStatus;
import com.example.ambulanceserviceprovider.service.AmbulanceService;
import com.example.ambulanceserviceprovider.service.RequestService;
import com.example.ambulanceserviceprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private AmbulanceService ambulanceService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Request> createRequest(@RequestBody RequestDto requestDto) {
        // Use the DTO to create the Request
        Request request = new Request();
        request.setUser(userService.getUserById(requestDto.getUserId()));  // Assuming you have a method to get the User by ID
        request.setAmbulance(ambulanceService.getAmbulanceById(requestDto.getAmbulanceId()));  // Use the AmbulanceService to get the ambulance by ID
        request.setPickupLocation(requestDto.getPickupLocation());
        request.setDropLocation(requestDto.getDropLocation());
        request.setStatus(RequestStatus.PENDING);  // Assuming RequestStatus is an enum
        request.setDetails("Details not provided in the request DTO");  // Default value for the details

        // Save and return the created request
        Request savedRequest = requestService.createRequest(request);
        return ResponseEntity.ok(savedRequest);
    }

    @GetMapping
    public ResponseEntity<List<Request>> getAllRequests() {
        List<Request> requests = requestService.getAllRequests();
        return ResponseEntity.ok(requests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getRequestById(@PathVariable Long id) {
        Request request = requestService.getRequestById(id);
        return ResponseEntity.ok(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Request> updateRequest(@PathVariable Long id, @RequestBody Request updatedRequest) {
        Request request = requestService.updateRequest(id, updatedRequest);
        return ResponseEntity.ok(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        requestService.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}