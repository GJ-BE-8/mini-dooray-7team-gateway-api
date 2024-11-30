package com.nhnacademy.minidooray.gateway.domain.member.model;

import lombok.*;

@Data
public class MemberDto {
    private String id;
    private String email;
    private String pwd;

    public MemberDto() {}

    public MemberDto(String id, String email, String pwd) {
      this.id = id;
      this.email = email;
      this.pwd = pwd;
    }
}
