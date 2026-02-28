package com.smarttoken.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.smarttoken.service.TokenService;
import com.smarttoken.entity.Token;

@RestController
@RequestMapping("/token")
public class TokenController {

    private final TokenService tokenService;

    // 🔥 MANUAL CONSTRUCTOR
    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/generate")
    public Token generate() {
        return tokenService.generateToken();
    }

    @PostMapping("/assign")
    public Token assign(@RequestParam Long tokenId,
                        @RequestParam Long counterId) {
        return tokenService.assignCounter(tokenId, counterId);
    }
    @GetMapping("/all")
    public List<Token> getAllTokens() {
        return tokenService.getAllTokens();
    }
}