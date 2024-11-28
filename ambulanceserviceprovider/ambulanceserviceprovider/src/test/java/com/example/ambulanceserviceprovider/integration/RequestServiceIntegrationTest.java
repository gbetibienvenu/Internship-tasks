package com.example.ambulanceserviceprovider.integration;


//import com.example.ambulanceservice.model.Request;
//import com.example.ambulanceservice.repository.RequestRepository;
//import com.example.ambulanceservice.service.RequestService;
import com.example.ambulanceserviceprovider.model.Request;
import com.example.ambulanceserviceprovider.repository.RequestRepository;
import com.example.ambulanceserviceprovider.service.RequestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class RequestServiceIntegrationTest {

    @Autowired
    private RequestService requestService;

    @Autowired
    private RequestRepository requestRepository;

    @Test
    public void testCreateRequest() {
        Request request = new Request();
        request.setDetails("Need an ambulance for a medical emergency");

        Request savedRequest = requestService.createRequest(request);
        assertThat(savedRequest).isNotNull();
        assertThat(savedRequest.getId()).isNotNull();
        assertThat(savedRequest.getDetails()).isEqualTo("Need an ambulance for a medical emergency");
    }

    @Test
    public void testGetAllRequests() {
        // Create a request to ensure there is at least one in the database
        Request request = new Request();
        request.setDetails("Need an ambulance for a medical emergency");
        requestService.createRequest(request);

        // Now fetch all requests
        List<Request> requests = requestService.getAllRequests();
        assertThat(requests).isNotEmpty();
        assertThat(requests.size()).isGreaterThan(0);
    }

    @Test
    public void testGetRequestById() {
        // Create a request
        Request request = new Request();
        request.setDetails("Need an ambulance for a medical emergency");
        Request savedRequest = requestService.createRequest(request);

        // Fetch the request by ID
        Request fetchedRequest = requestService.getRequestById(savedRequest.getId());
        assertThat(fetchedRequest).isNotNull();
        assertThat(fetchedRequest.getId()).isEqualTo(savedRequest.getId());
    }
}