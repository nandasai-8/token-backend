package com.smarttoken.repository;

import com.smarttoken.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TokenRepository extends JpaRepository<Token, Long> {
    List<Token> findByStatus(String status);
}