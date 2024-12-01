package com.nhnacademy.minidooray.gateway.domain.member.request.modify;

import com.nhnacademy.minidooray.gateway.domain.member.model.Role;
import lombok.Data;

@Data
public class MemberRoleUpdateDto {
    private Role role;

    public MemberRoleUpdateDto() {}

    public MemberRoleUpdateDto(Role role) {
        this.role = role;
    }
}
