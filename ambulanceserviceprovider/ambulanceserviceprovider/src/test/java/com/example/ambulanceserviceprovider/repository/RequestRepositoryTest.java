package com.example.ambulanceserviceprovider.repository;

import com.example.ambulanceserviceprovider.model.Request;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RequestRepositoryTest {

    @Autowired
    private RequestRepository requestRepository;

    @Test
    public void testSaveRequest() {
        Request request = new Request();
        request.setDetails("Need an ambulance for a medical emergency");

        Request savedRequest = requestRepository.save(request);
        assertThat(savedRequest).isNotNull();
        assertThat(savedRequest.getId()).isNotNull();
        assertThat(savedRequest.getDetails()).isEqualTo("Need an ambulance for a medical emergency");
    }

    @Test
    public void testFindRequestById() {
        Request request = new Request();
        request.setDetails("Need an ambulance for a medical emergency");
        Request savedRequest = requestRepository.save(request);

        Optional<Request> foundRequest = requestRepository.findById(savedRequest.getId());
        assertThat(foundRequest).isPresent();
        assertThat(foundRequest.get().getDetails()).isEqualTo("Need an ambulance for a medical emergency");
    }

    @Test
    public void testDeleteRequest() {
        Request request = new Request();
        request.setDetails("Need an ambulance for a medical emergency");
        Request savedRequest = requestRepository.save(request);

        requestRepository.delete(savedRequest);
        Optional<Request> deletedRequest = requestRepository.findById(savedRequest.getId());
        assertThat(deletedRequest).isNotPresent();
    }
}