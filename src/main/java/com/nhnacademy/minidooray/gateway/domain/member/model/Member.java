package com.nhnacademy.minidooray.gateway.domain.member.model;

import lombok.Data;

@Data
public class Member {
  private String id;
  private String email;
  private String pwd;
  private Role role;
}
