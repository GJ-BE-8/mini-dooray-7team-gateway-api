package com.nhnacademy.minidooray.gateway.domain.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Member {
  private String id;
  private String email;
  private String password;
  private Role role;
  private Status status;
}
