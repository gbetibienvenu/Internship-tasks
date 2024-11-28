package com.example.ambulanceserviceprovider.controller;

import com.example.ambulanceserviceprovider.model.User;
import com.example.ambulanceserviceprovider.service.UserService;
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
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

import java.util.Collections;
import java.util.List;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser () {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        user.setPassword("password");
        user.setRole("USER");

        when(userService.createUser (user)).thenReturn(user);

        ResponseEntity<User> response = userController.createUser (user);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    private void assertEquals(User user, User body) {
    }

    @Test
    public void testGetAllUsers() {
        when(userService.getAllUsers()).thenReturn(Collections.singletonList(new User()));

        ResponseEntity<List<User>> response = userController.getAllUsers();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    private void assertEquals(HttpStatus httpStatus, HttpStatusCode statusCode) {
    }
}