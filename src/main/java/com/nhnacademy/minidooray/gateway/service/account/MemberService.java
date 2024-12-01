package com.nhnacademy.minidooray.gateway.service.account;

import com.nhnacademy.minidooray.gateway.domain.member.model.Member;
import com.nhnacademy.minidooray.gateway.domain.member.model.MemberFindDto;
import com.nhnacademy.minidooray.gateway.feignclient.AccountApiClient;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final AccountApiClient accountApiClient;

    public MemberService(AccountApiClient accountApiClient) {
        this.accountApiClient = accountApiClient;
    }

    public MemberFindDto findById(String id) {
        return accountApiClient.findByUserId(id);
    }

    public Member getMember(String id) {
         Member member = new Member();
         member.setId(id);
         return member;
    }

}
