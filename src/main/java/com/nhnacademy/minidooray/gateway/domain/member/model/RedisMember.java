package com.nhnacademy.minidooray.gateway.domain.member.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

@Data
public class RedisMember implements UserDetails {
    private String id;
    private String email;
    private String password;
    private Role role;
    private Status status;

    public RedisMember() {}

    public RedisMember(String id, String email, String password, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public RedisMember(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.password = member.getPassword();
        this.role = member.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = "ROLE_" + this.role;
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }


}
