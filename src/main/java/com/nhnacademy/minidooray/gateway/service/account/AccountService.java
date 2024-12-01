package com.nhnacademy.minidooray.gateway.service.account;

import com.nhnacademy.minidooray.gateway.domain.member.request.login.LoginRequestDto;
import com.nhnacademy.minidooray.gateway.domain.member.request.modify.MemberRoleUpdateDto;
import com.nhnacademy.minidooray.gateway.domain.member.request.modify.MemberStatusUpdateDto;
import com.nhnacademy.minidooray.gateway.domain.member.request.register.MemberCreateDto;
import com.nhnacademy.minidooray.gateway.feignclient.AccountApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountApiClient accountApiClient;

    @Autowired
    public AccountService(AccountApiClient accountApiClient) {
        this.accountApiClient = accountApiClient;
    }

    public LoginRequestDto login(LoginRequestDto loginRequestDto) {
        return accountApiClient.login(loginRequestDto);
    }

//    // 사용자 인증 처리
//    public boolean authenticateUser(MemberLoginDto memberLoginDto) {
//
//        // FeignClient를 사용하여 인증 요청
//        return accountApiClient.registerUser();
//    }

    // 회원가입 처리
    public MemberCreateDto registerUser(MemberCreateDto memberCreateDto) {
        // FeignClient를 사용하여 회원가입 요청
        return accountApiClient.registerUser(memberCreateDto);
    }

    public MemberStatusUpdateDto updateMemberStatus(String userId, MemberStatusUpdateDto memberStatusUpdateDto) {
        return accountApiClient.statusUpdateUser(userId, memberStatusUpdateDto);
    }

    public MemberRoleUpdateDto updateMemberRole(String userId, MemberRoleUpdateDto memberRoleUpdateDto) {
        return accountApiClient.roleUpdateUser(userId, memberRoleUpdateDto);
    }


}
