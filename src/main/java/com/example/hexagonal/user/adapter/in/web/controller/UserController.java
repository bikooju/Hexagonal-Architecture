package com.example.hexagonal.user.adapter.in.web.controller;

import com.example.hexagonal.common.mapper.UserMapper;
import com.example.hexagonal.user.adapter.in.web.dto.request.RegisterUserRequest;
import com.example.hexagonal.user.adapter.in.web.dto.response.RegisterUserResponse;
import com.example.hexagonal.user.application.command.RegisterUserCommand;
import com.example.hexagonal.user.application.port.in.UserUseCase;
import com.example.hexagonal.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HTTP 요청을 받아 유스케이스를 호출하는 진입점 (IN 어댑터)
 * - Request DTO -> Command 변환
 * - Command를 유스케이스에 전달
 * - 결과 Domain -> Response DTO 변환 후 반환
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register(@RequestBody RegisterUserRequest request) {
        RegisterUserCommand command = UserMapper.toRegisterCommand(request); // Request → Command 변환
        User user = userUseCase.register(command); // 유스케이스 실행
        RegisterUserResponse response = UserMapper.toResponse(user); // Domain → Response DTO 변환
        return ResponseEntity.ok(response);
    }
}
