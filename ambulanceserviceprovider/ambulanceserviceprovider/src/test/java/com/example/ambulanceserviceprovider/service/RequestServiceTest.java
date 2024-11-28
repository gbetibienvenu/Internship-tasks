package com.example.ambulanceserviceprovider.service;


import com.example.ambulanceserviceprovider.repository.RequestRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RequestServiceTest<Request> {

    @Mock
    private RequestRepository requestRepository;

    @InjectMocks
    private RequestService requestService;

    public RequestServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateRequest() {
        Request request = new Request();
        request.setDetails("Need an ambulance for a medical emergency");

        when(requestRepository.save(any(Request.class))).thenReturn(request);

        Request savedRequest = requestService.createRequest(request);
        assertThat(savedRequest).isNotNull();
        assertThat(savedRequest.getDetails()).isEqualTo("Need an ambulance for a medical emergency");
        verify(requestRepository, times(1)).save(request);
    }

    @Test
    public void testGetRequestById() {
        Request request = new Request();
        request.setId(1L);
        request.setDetails("Need an ambulance for a medical emergency");

        when(requestRepository.findById(1L)).thenReturn(Optional.of(request));

        Request foundRequest = requestService.getRequestById(1L);
        assertThat(foundRequest).isNotNull();
        assertThat(foundRequest.getId()).isEqualTo(1L);
        assertThat(foundRequest.getDetails()).isEqualTo("Need an ambulance for a medical emergency");
    }

    @Test
    public void testGetAllRequests() {
        when(requestRepository.findAll()).thenReturn(List.of(new Request("Need an ambulance for a medical emergency")));

        List<Request> requests = requestService.getAllRequests();
        assertThat(requests).isNotEmpty();
        assertThat(requests.size()).isEqualTo(1);
    }
}
