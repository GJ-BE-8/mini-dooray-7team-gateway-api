package com.nhnacademy.minidooray.gateway.domain.member.request.register;

import lombok.Data;

@Data
public class MemberCreateDto {
    private String id;
    private String email;
    private String password;

    public MemberCreateDto() {}

    public MemberCreateDto(String id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
