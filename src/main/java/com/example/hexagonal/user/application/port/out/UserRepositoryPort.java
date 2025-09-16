package com.example.hexagonal.user.application.port.out;

import com.example.hexagonal.user.domain.model.User;

import java.util.Optional;

/**
 * repository 인터페이스 [out 포트]
 * - 애플리케이션이 DB 접근 방식을 알 필요 없이
 * 추상화된 메서드로만 저장/조회 가능
 */
public interface UserRepositoryPort {
    boolean exitsByEmail(String email);
    User save(User user);
    Optional<User> findById(Long id);
}
