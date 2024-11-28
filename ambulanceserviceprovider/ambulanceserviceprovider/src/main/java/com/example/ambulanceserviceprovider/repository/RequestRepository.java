package com.example.ambulanceserviceprovider.repository;

import com.example.ambulanceserviceprovider.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {

}