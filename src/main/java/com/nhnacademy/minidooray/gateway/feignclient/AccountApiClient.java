package com.nhnacademy.minidooray.gateway.feignclient;

import com.nhnacademy.minidooray.gateway.domain.member.model.Member;
import com.nhnacademy.minidooray.gateway.domain.member.model.MemberFindDto;
import com.nhnacademy.minidooray.gateway.domain.member.model.MemberListDto;
import com.nhnacademy.minidooray.gateway.domain.member.request.login.LoginRequestDto;
import com.nhnacademy.minidooray.gateway.domain.member.request.modify.MemberRoleUpdateDto;
import com.nhnacademy.minidooray.gateway.domain.member.request.modify.MemberStatusUpdateDto;
import com.nhnacademy.minidooray.gateway.domain.member.request.register.MemberCreateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "accountApiClient", url = "http://localhost:8081")  // 외부 API URL을 입력
public interface AccountApiClient {


    // 회원가입
    @PostMapping("/users")
    MemberCreateDto registerUser(@RequestBody MemberCreateDto memberCreateDto);
    //로그인
    @PostMapping("/users/login")
    LoginRequestDto login(@RequestBody LoginRequestDto loginRequestDto);

    @GetMapping("/users")
    List<MemberListDto> getAllUsers(@RequestBody MemberListDto memberListDto);
    // 사용자 조회 ( id로 )
    @GetMapping("/users/{user_id}")
    MemberFindDto findByUserId(@PathVariable("user_id") String userId);

    @PutMapping("/users/{user_id}/status")
    MemberStatusUpdateDto statusUpdateUser(@PathVariable("user_id") String user_id, @RequestBody MemberStatusUpdateDto memberStatusUpdateDto);

    @PutMapping("users/{user_id}/role")
    MemberRoleUpdateDto roleUpdateUser(@PathVariable("user_id") String userId, @RequestBody MemberRoleUpdateDto memberRoleUpdateDto);

//    // 사용자 로그인 인증 요청(사용자 아이디, 비밀번호 전송)
//    @PostMapping("/authenticate")  // 외부 API에서 로그인 인증을 처리하는 엔드포인트
//    boolean authenticateUser(@RequestBody String id, @RequestBody String password);
}