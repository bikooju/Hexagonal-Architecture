package com.example.hexagonal.user.adapter.in.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *  HTTP 요청 DTO (웹 전용)
 *  - 클라이언트가 보낸 JSON Body를 매핑
 *  - 유스케이스 직접 호출 X (Command로 변환해서 사용)
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserRequest {
    private String email;
    private String name;
    private String password;
}
