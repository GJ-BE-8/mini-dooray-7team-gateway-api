package com.nhnacademy.minidooray.gateway.domain.account.model;

import lombok.Data;

@Data
public class Member {
  private String id;
  private String email;
  private String pwd;
  private Role role;
}
