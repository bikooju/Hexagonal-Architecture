package com.example.hexagonal.user.application.port.in;

import com.example.hexagonal.user.application.command.RegisterUserCommand;
import com.example.hexagonal.user.domain.model.User;

/**
 * 유스케이스 인터페이스 (서비스 인터페이스) [in 포트]
 * - 컨트롤러가 호출할 수 있는 유스케이스 정의
 */
public interface UserUseCase {
    User register(RegisterUserCommand command);
}
