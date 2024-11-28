package com.example.ambulanceserviceprovider.controller;

import com.example.ambulanceserviceprovider.model.Request;
import com.example.ambulanceserviceprovider.service.RequestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class RequestControllerTest {

    @InjectMocks
    private RequestController requestController;

    @Mock
    private RequestService requestService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateRequest() {
        Request request = new Request();
        request.setPickupLocation("Location A");
        request.setDropLocation("Location B");

        when(requestService.createRequest(request)).thenReturn(request);

        ResponseEntity<Request> response = requestController.createRequest(request);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(request, response.getBody());
    }

    @Test
    public void testGetAllRequests() {
        when(requestService.getAllRequests()).thenReturn(Collections.singletonList(new Request()));

        ResponseEntity<List<Request>> response = requestController.getAllRequests();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}