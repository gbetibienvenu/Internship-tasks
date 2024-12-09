package com.example.ambulanceserviceprovider.service;

import com.example.ambulanceserviceprovider.model.Request;
import com.example.ambulanceserviceprovider.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserService userService; // Service to fetch User objects

    @Autowired
    private AmbulanceService ambulanceService;

    /**
     * Create a new request.
     *
     * @param request The Request object to be saved.
     * @return The saved Request object.
     */
    public Request createRequest(Request request) {
        validateRequest(request); // Validate the request data before saving
        return requestRepository.save(request);
    }

    /**
     * Retrieve all requests.
     *
     * @return A list of all Request objects.
     */
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    /**
     * Retrieve a specific request by its ID.
     *
     * @param id The ID of the request to retrieve.
     * @return The found Request object.
     */
    public Request getRequestById(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request with ID " + id + " not found"));
    }

    /**
     * Update an existing request.
     *
     * @param id The ID of the request to update.
     * @param updatedRequest The new request data.
     * @return The updated Request object.
     */
    public Request updateRequest(Long id, Request updatedRequest) {
        Request request = getRequestById(id);

        // Update related entities and validate them
        if (updatedRequest.getUser() != null) {
            request.setUser(userService.getUserById(updatedRequest.getUser().getId()));
        }
        if (updatedRequest.getAmbulance() != null) {
            request.setAmbulance(ambulanceService.getAmbulanceById(updatedRequest.getAmbulance().getId())); // Use the AmbulanceService to fetch the Ambulance
        }

        // Update other fields
        request.setStatus(updatedRequest.getStatus());
        request.setDetails(updatedRequest.getDetails());
        request.setPickupLocation(updatedRequest.getPickupLocation());
        request.setDropLocation(updatedRequest.getDropLocation());

        return requestRepository.save(request);
    }

    /**
     * Delete a request by its ID.
     *
     * @param id The ID of the request to delete.
     */
    public void deleteRequest(Long id) {
        Request request = getRequestById(id);
        requestRepository.delete(request);
    }

    /**
     * Validate a request object.
     *
     * @param request The request object to validate.
     */
    private void validateRequest(Request request) {
        if (request.getUser() == null) {
            throw new IllegalArgumentException("User must not be null.");
        }
        if (request.getAmbulance() == null) {
            throw new IllegalArgumentException("Ambulance must not be null.");
        }
        if (request.getPickupLocation() == null || request.getPickupLocation().isEmpty()) {
            throw new IllegalArgumentException("Pickup location must not be null or empty.");
        }
        if (request.getDropLocation() == null || request.getDropLocation().isEmpty()) {
            throw new IllegalArgumentException("Drop location must not be null or empty.");
        }
        if (request.getStatus() == null) {
            throw new IllegalArgumentException("Status must not be null.");
        }
    }
}
