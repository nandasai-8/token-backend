package com.smarttoken.controller;

import org.springframework.web.bind.annotation.*;
import com.smarttoken.entity.User;
import com.smarttoken.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 🔐 Protected API
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}