package com.example.shoppingcart.repository;

import com.example.shoppingcart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    User findByUsername(String username);
Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}

