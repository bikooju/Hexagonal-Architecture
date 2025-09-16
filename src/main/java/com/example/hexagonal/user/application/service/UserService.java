package com.example.hexagonal.user.application.service;

import com.example.hexagonal.user.application.command.RegisterUserCommand;
import com.example.hexagonal.user.application.port.in.UserUseCase;
import com.example.hexagonal.user.application.port.out.UserRepositoryPort;
import com.example.hexagonal.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 유스케이스 구현체
 */
@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    @Transactional
    public User register(RegisterUserCommand command) {
        if (userRepositoryPort.exitsByEmail(command.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        // Command -> 도메인 모델 생성 (정적 팩토리 메서드 사용)
        User user = command.toDomain();

        return userRepositoryPort.save(user);
    }
}
