package com.example.ambulanceserviceprovider.controller;

import com.example.ambulanceserviceprovider.model.Ambulance;
import com.example.ambulanceserviceprovider.service.AmbulanceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

public class AmbulanceControllerTest {

    @InjectMocks
    private AmbulanceController ambulanceController;

    @Mock
    private AmbulanceService ambulanceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateAmbulance() {
        HttpStatus ambulance = new Ambulance();
        ambulance.series("ABC-123");

        when(ambulanceService.createAmbulance(ambulance)).thenReturn(ambulance);

        ResponseEntity<Ambulance> response = ambulanceController.createAmbulance(ambulance);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ambulance, response.getBody());
    }

    private void assertEquals(HttpStatus httpStatus, HttpStatusCode statusCode) {
    }

    @Test
    public void testGetAllAmbulances() {
        when(ambulanceService.getAllAmbulances()).thenReturn(Collections.singletonList(new Ambulance()));

        ResponseEntity<List<Ambulance>> response = ambulanceController.getAllAmbulances();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}