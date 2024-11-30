package com.nhnacademy.minidooray.gateway.domain.member.request.login;

import lombok.Data;

@Data
public class MemberLoginDto {
    private String id;
    private String pwd;
}
