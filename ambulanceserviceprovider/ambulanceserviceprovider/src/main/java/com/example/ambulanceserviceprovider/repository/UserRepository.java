package com.example.ambulanceserviceprovider.repository;


import com.example.ambulanceserviceprovider.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}