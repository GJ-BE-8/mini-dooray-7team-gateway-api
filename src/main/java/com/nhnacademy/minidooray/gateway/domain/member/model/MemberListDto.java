package com.nhnacademy.minidooray.gateway.domain.member.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberListDto {
    private String id;
    private String email;
    private String password;
    private Role role;
    private Status status;
}
