package com.smarttoken.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smarttoken.entity.User;
import com.smarttoken.repository.UserRepository;
import com.smarttoken.dto.RegisterRequest;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register
    public User register(RegisterRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        return userRepository.save(user);
    }

    // Login
    public User login(String email, String password) {

        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(password))
                .orElseThrow(() -> new RuntimeException("Invalid Email or Password"));
    }

    // Get All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}