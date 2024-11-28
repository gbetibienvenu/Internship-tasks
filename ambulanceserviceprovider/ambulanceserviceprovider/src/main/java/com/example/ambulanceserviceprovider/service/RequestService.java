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

    public Request createRequest(Request request) {
        return requestRepository.save(request);
    }

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    // Other service methods
}