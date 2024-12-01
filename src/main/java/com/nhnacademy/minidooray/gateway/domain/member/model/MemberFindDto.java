package com.nhnacademy.minidooray.gateway.domain.member.model;

import lombok.*;

@Data
public class MemberFindDto {
    private String userId;
    private String email;
    private String password;
    private Role role;
    private Status status;

    public MemberFindDto() {}

    public MemberFindDto(String userId, String email, String password, Role role, Status status) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
    }
}
