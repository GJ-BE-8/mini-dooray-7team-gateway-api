package com.nhnacademy.minidooray.gateway.domain.account.request.modify;

import com.nhnacademy.minidooray.gateway.domain.account.model.Role;
import lombok.Data;

@Data
public class MemberUpdateDto {
  private String id;
  private String email;
  private String password;
  private Role role;
}
