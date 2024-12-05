package com.example.ambulanceserviceprovider.service;

import com.example.ambulanceserviceprovider.model.User;
import com.example.ambulanceserviceprovider.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Retrieve all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Retrieve a user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with ID " + id + " not found"));
    }

    // Update an existing user
    public User updateUser(Long id, User updatedUser) {
        User user = getUserById(id);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setRole(updatedUser.getRole());
        user.setPassword(updatedUser.getPassword());
        return userRepository.save(user);
    }

    // Delete a user by ID
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}














//package com.example.ambulanceserviceprovider.service;
//
//import com.example.ambulanceserviceprovider.model.User;
//import com.example.ambulanceserviceprovider.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    public User createUser (User user) {
//        return userRepository.save(user);
//    }
//
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    // Other service methods
//}