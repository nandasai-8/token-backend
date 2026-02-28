package com.smarttoken.controller;

import org.springframework.web.bind.annotation.*;

import com.smarttoken.service.AuthService;
import com.smarttoken.dto.*;
import com.smarttoken.entity.User;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authService.register(
                request.getEmail(),
                request.getPassword()
        );
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        System.out.println("LOGIN API CALLED");
        return authService.login(user.getEmail(), user.getPassword());
    }}