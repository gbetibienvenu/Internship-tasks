package com.example.shoppingcart.repository;

import com.example.shoppingcart.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldSaveUser() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("password");

        User savedUser = userRepository.save(user);

        assertNotNull(savedUser);
        assertEquals("testUser", savedUser.getUsername());
    }

    @Test
    void shouldFindUserByUsername() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("password");

        userRepository.save(user);
        Optional<User> foundUser = userRepository.findByUsername("testUser");

        assertNotNull(foundUser);
        assertEquals("testUser", foundUser.stream());
    }
}

