package com.example.ambulanceserviceprovider.repository;


import com.example.ambulanceserviceprovider.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser () {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password");

        User savedUser  = userRepository.save(user);
        assertThat(savedUser ).isNotNull();
        assertThat(savedUser .getId()).isNotNull();
        assertThat(savedUser .getName()).isEqualTo("John Doe");
    }

    @Test
    public void testFindByEmail() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password");
        userRepository.save(user);

        User foundUser  = userRepository.findByEmail("john.doe@example.com");
        assertThat(foundUser ).isNotNull();
        assertThat(foundUser .getEmail()).isEqualTo("john.doe@example.com");
    }

    @Test
    public void testDeleteUser () {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password");
        User savedUser  = userRepository.save(user);

        userRepository.delete(savedUser );
        Optional<User> deletedUser  = userRepository.findById(savedUser .getId());
        assertThat(deletedUser ).isNotPresent();
    }
}