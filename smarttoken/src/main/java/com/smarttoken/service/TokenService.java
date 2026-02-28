package com.smarttoken.service;

import org.springframework.stereotype.Service;
import com.smarttoken.repository.*;
import com.smarttoken.entity.*;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TokenService {

    private final TokenRepository tokenRepository;
    private final CounterRepository counterRepository;

    // 🔥 MANUAL CONSTRUCTOR
    public TokenService(TokenRepository tokenRepository,
                        CounterRepository counterRepository) {
        this.tokenRepository = tokenRepository;
        this.counterRepository = counterRepository;
    }

    private int tokenSequence = 1;

    public Token generateToken() {

        Token token = new Token();
        token.setTokenNumber(tokenSequence++);
        token.setStatus("WAITING");
        token.setCreatedTime(LocalDateTime.now());

        return tokenRepository.save(token);
    }

    public Token assignCounter(Long tokenId, Long counterId) {

        Token token = tokenRepository.findById(tokenId).orElseThrow();
        Counter counter = counterRepository.findById(counterId).orElseThrow();

        token.setCounter(counter);
        token.setStatus("SERVED");

        return tokenRepository.save(token);
    }
    public List<Token> getAllTokens() {
        return tokenRepository.findAll();
    }
}