package com.nhnacademy.minidooray.gateway.domain.member.request.modify;

import com.nhnacademy.minidooray.gateway.domain.member.model.Member;
import com.nhnacademy.minidooray.gateway.domain.member.model.Status;
import lombok.Data;

@Data
public class MemberStatusUpdateDto {
  private Status status;

  public MemberStatusUpdateDto() {}

  public MemberStatusUpdateDto(Member member) {
    this.status = member.getStatus();
  }
}
