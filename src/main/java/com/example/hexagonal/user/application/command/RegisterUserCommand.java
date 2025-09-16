package com.example.hexagonal.user.application.command;

import com.example.hexagonal.user.domain.model.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 유스케이스 입력 모델 (Command)
 * - Request DTO와 분리 (컨트롤러에서 Request DTO -> Command로 변환)
 * - 회원가입 유스케이스 실행에 필요한 값만 캡슐화
 * - 웹 외에도 배치/메시지 큐 등에서 같은 유스케이스 실행 가능
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE) // 생성자의 접근 제어자를 private으로 두서 외부에서 new RegisterUserCommand(...)호출 불가
public class RegisterUserCommand {
    private final String email;
    private final String name;
    private final String password;

    // 정적 팩토리 메서드를 통해서만 만들 수 있도록 강제
    public static RegisterUserCommand of(String email, String name, String password) {
        return new RegisterUserCommand(email, name, password);
    }

    // Command -> Domain 변환
    public User toDomain() {
        return User.of(email, name, password, LocalDateTime.now());
    }
}
