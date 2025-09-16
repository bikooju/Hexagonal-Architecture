package com.example.hexagonal.common.mapper;

import com.example.hexagonal.user.adapter.in.web.dto.request.RegisterUserRequest;
import com.example.hexagonal.user.adapter.in.web.dto.response.RegisterUserResponse;
import com.example.hexagonal.user.adapter.out.persistence.entity.UserEntity;
import com.example.hexagonal.user.application.command.RegisterUserCommand;
import com.example.hexagonal.user.domain.model.User;

public class UserMapper {

    private UserMapper() {}

    // Request -> Command
    public static RegisterUserCommand toRegisterCommand(RegisterUserRequest request) {
        return RegisterUserCommand.of(
                request.getEmail(),
                request.getName(),
                request.getPassword()
        );
    }

    // Domain -> Response
    public static RegisterUserResponse toResponse(User user) {
        return new RegisterUserResponse(
                user.getId() != null ? user.getId().toString() : null,
                user.getEmail(),
                user.getName()
        );
    }

    // Domain -> Entity
    public static UserEntity toEntity(User user) {
        return UserEntity.builder()
                .id(Long.valueOf(user.getId()))
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    // Entity -> Domain
    public static User toDomain(UserEntity e) {
        return User.of(
                e.getId(),
                e.getEmail(),
                e.getName(),
                e.getPassword(),
                e.getCreatedAt()
        );
    }


}
