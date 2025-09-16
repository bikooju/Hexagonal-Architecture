package com.example.hexagonal.user.adapter.out.persistence.jpa;

import com.example.hexagonal.user.adapter.out.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);
}
