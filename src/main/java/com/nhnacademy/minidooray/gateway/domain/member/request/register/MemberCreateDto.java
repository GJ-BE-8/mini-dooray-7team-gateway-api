package com.nhnacademy.minidooray.gateway.domain.member.request.register;

import lombok.Data;

@Data
public class MemberCreateDto {
    private String id;
    private String email;
    private String pwd;
}
