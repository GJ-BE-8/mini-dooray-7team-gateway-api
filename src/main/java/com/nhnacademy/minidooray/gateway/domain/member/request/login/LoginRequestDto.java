package com.nhnacademy.minidooray.gateway.domain.member.request.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginRequestDto {
    @JsonProperty("user_id")
    private String userId;
    private String password;

    public LoginRequestDto() {}

    public LoginRequestDto(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
