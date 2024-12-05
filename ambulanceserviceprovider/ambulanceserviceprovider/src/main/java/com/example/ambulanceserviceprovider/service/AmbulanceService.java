package com.example.ambulanceserviceprovider.service;

import com.example.ambulanceserviceprovider.model.Ambulance;
import com.example.ambulanceserviceprovider.model.Request;
import com.example.ambulanceserviceprovider.model.RequestStatus;
import com.example.ambulanceserviceprovider.model.User;
import com.example.ambulanceserviceprovider.repository.RequestRepository;
import com.example.ambulanceserviceprovider.repository.AmbulanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmbulanceService {

    private final RequestRepository requestRepository;
    private final AmbulanceRepository ambulanceRepository;

    @Autowired
    public AmbulanceRequestService(RequestRepository requestRepository, AmbulanceRepository ambulanceRepository) {
        this.requestRepository = requestRepository;
        this.ambulanceRepository = ambulanceRepository;
    }

    // Create a new request
    public Request createRequest(Request request) {
        validateRequest(request);
        return requestRepository.save(request);
    }

    // Retrieve all requests
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    // Retrieve a specific request by its ID
    public Request getRequestById(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request with ID " + id + " not found"));
    }

    // Update an existing request
    public Request updateRequest(Long id, Request updatedRequest) {
        Request request = getRequestById(id);

        if (updatedRequest.getUser() != null) {
            request.setUser(updatedRequest.getUser());
        }

        if (updatedRequest.getAmbulance() != null) {
            request.setAmbulance(updatedRequest.getAmbulance());
        }

        request.setStatus(updatedRequest.getStatus());
        request.setPickupLocation(updatedRequest.getPickupLocation());
        request.setDropLocation(updatedRequest.getDropLocation());
        request.setDetails(updatedRequest.getDetails());

        return requestRepository.save(request);
    }

    // Delete a request
    public void deleteRequest(Long id) {
        Request request = getRequestById(id);
        requestRepository.delete(request);
    }

    // Create a new ambulance
    public Ambulance createAmbulance(Ambulance ambulance) {
        return ambulanceRepository.save(ambulance);
    }

    // Retrieve all ambulances
    public List<Ambulance> getAllAmbulances() {
        return ambulanceRepository.findAll();
    }

    // Retrieve an ambulance by its ID
    public Ambulance getAmbulanceById(Long id) {
        return ambulanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ambulance with ID " + id + " not found"));
    }

    // Update an existing ambulance
    public Ambulance updateAmbulance(Long id, Ambulance updatedAmbulance) {
        Ambulance ambulance = getAmbulanceById(id);
        ambulance.setStatus(updatedAmbulance.getStatus());
        ambulance.setType(updatedAmbulance.getType());
        ambulance.setLocation(updatedAmbulance.getLocation());
        return ambulanceRepository.save(ambulance);
    }

    // Delete an ambulance
    public void deleteAmbulance(Long id) {
        Ambulance ambulance = getAmbulanceById(id);
        ambulanceRepository.delete(ambulance);
    }

    // Create a request using parameters
    public Request createNewRequest(Long userId, Long ambulanceId, String pickupLocation, String dropLocation, String details) {
        User user = new User();  // Assuming UserService is not used in this version.
        Ambulance ambulance = getAmbulanceById(ambulanceId);

        Request request = new Request();
        request.setUser(user);
        request.setAmbulance(ambulance);
        request.setPickupLocation(pickupLocation);
        request.setDropLocation(dropLocation);
        request.setDetails(details);
        request.setStatus(RequestStatus.PENDING);

        return requestRepository.save(request);
    }

    // Validate the request data
    private void validateRequest(Request request) {
        if (request.getUser() == null || request.getAmbulance() == null || request.getPickupLocation() == null || request.getDropLocation() == null || request.getStatus() == null) {
            throw new IllegalArgumentException("Invalid request data");
        }
    }
}
