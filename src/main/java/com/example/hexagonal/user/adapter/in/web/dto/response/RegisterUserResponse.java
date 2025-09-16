package com.example.hexagonal.user.adapter.in.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * HTTP 응답 DTO
 * - 컨트롤러가 Domain 모델을 변환해서 반환
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserResponse {
    private String id;
    private String email;
    private String name;
}
