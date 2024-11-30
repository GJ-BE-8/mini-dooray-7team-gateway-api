package com.nhnacademy.minidooray.gateway.domain.member.request.modify;

import com.nhnacademy.minidooray.gateway.domain.member.model.Role;
import lombok.Data;

@Data
public class MemberUpdateDto {
  private String id;
  private Role role;
}
