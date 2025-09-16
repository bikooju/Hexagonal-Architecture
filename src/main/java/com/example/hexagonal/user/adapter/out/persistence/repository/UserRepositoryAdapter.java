package com.example.hexagonal.user.adapter.out.persistence.repository;

import com.example.hexagonal.common.mapper.UserMapper;
import com.example.hexagonal.user.adapter.out.persistence.entity.UserEntity;
import com.example.hexagonal.user.adapter.out.persistence.jpa.UserJpaRepository;
import com.example.hexagonal.user.application.port.out.UserRepositoryPort;
import com.example.hexagonal.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * OUT 어댑터 (Out 포트 구현체)
 * - Application 계층에서 요청받아 DB에 저장/조회
 * - Domain <-> Entity 변환 책임은 Mapper에게 위임
 */
@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public boolean exitsByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        UserEntity saved = userJpaRepository.save(entity);
        return UserMapper.toDomain(saved); // Entity -> Domain
    }

    @Override
    public Optional<User> findById(String id) {
        Long longId = Long.valueOf(id);
        return userJpaRepository.findById(longId).map(UserMapper::toDomain);
    }
}
