package com.example.hexagonal.user.domain.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    private final Long id;
    private final String email;
    private final String name;
    private final String password;
    private final LocalDateTime createdAt;

    public static User of(String email, String name, String password, LocalDateTime createdAt) {
        return new User(null, email, name, password, createdAt);
    }

    public static User of(Long id, String email, String name, String password, LocalDateTime createdAt) {
        return new User(id, email, name, password, createdAt);
    }
}
