package com.nhnacademy.minidooray.gateway.controller.account;

import com.nhnacademy.minidooray.gateway.domain.member.model.Member;
import com.nhnacademy.minidooray.gateway.domain.member.model.MemberListDto;
import com.nhnacademy.minidooray.gateway.domain.member.request.login.LoginRequestDto;
import com.nhnacademy.minidooray.gateway.domain.member.request.modify.MemberRoleUpdateDto;
import com.nhnacademy.minidooray.gateway.domain.member.request.modify.MemberStatusUpdateDto;
import com.nhnacademy.minidooray.gateway.domain.member.request.register.MemberCreateDto;
import com.nhnacademy.minidooray.gateway.feignclient.AccountApiClient;
import com.nhnacademy.minidooray.gateway.service.account.AccountService;
import com.nhnacademy.minidooray.gateway.service.account.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//인가 인증용 입력 데이터 외부 API에 전달 및 기타용 controller

@Controller
@Slf4j
public class AccountController {

    private final AccountApiClient accountApiClient; // FeignClient를 사용하여 외부 API와 통신
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountApiClient accountApiClient, AccountService accountService) {
        this.accountApiClient = accountApiClient;
        this.accountService = accountService;
    }



    // 사용자 전체 목록 조회
    @GetMapping("/users")
    public List<MemberListDto> getUsers(@RequestBody List<MemberListDto> memberListDtos) {
        List<MemberListDto> memberListDtoList = memberListDtos;

        return memberListDtoList;
    }

    @PostMapping("/users")
    public MemberCreateDto register(@RequestBody MemberCreateDto memberCreateDto) {
        return memberCreateDto;
    }


    // 로그인
    @PostMapping("/users/{user_id}/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
//        LoginRequestDto loginRequest = userService.login(loginRequestDto.getUserId(), loginRequestDto.getPassword());
        return ResponseEntity.ok(login(loginRequestDto));
    }

    // 사용자 역할 변경
    @PutMapping("/users/{user_id}/role")
    public ResponseEntity<?> updateRole(@RequestBody MemberRoleUpdateDto roleUpdateDto) {


        return ResponseEntity.ok(roleUpdateDto);
    }

    // 사용자 상태 변경
    @PutMapping("/users/{user_id}/status")
    public ResponseEntity<?> updateStatus(@RequestBody MemberStatusUpdateDto statusUpdateDto) {
        return ResponseEntity.ok(statusUpdateDto);
    }



}
