package com.example.ambulanceserviceprovider.service;

//import com.example.ambulanceservice.model.User;
//import com.example.ambulanceservice.repository.UserRepository;
import com.example.ambulanceserviceprovider.model.User;
import com.example.ambulanceserviceprovider.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterUser () {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User registeredUser  = userService.registerUser (user);
        assertThat(registeredUser ).isNotNull();
        assertThat(registeredUser .getName()).isEqualTo("John Doe");
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testFindUser ById() {
        User user = new User();
        user.setId(1L);
        user.setName("John Doe");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User foundUser  = userService.findUser ById(1L);
        assertThat(foundUser ).isNotNull();
        assertThat(foundUser .getId()).isEqualTo(1L);
        assertThat(foundUser .getName()).isEqualTo("John Doe");
    }

    @Test
    public void testFindAllUsers() {
        when(userRepository.findAll()).thenReturn(List.of(new User("John Doe", "john.doe@example.com", "password")));

        List<User> users = userService.findAllUsers();
        assertThat(users).isNotEmpty();
        assertThat(users.size()).isEqualTo(1);
    }
}
