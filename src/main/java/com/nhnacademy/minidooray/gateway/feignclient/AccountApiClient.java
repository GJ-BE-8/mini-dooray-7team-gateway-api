package com.nhnacademy.minidooray.gateway.feignclient;

import com.nhnacademy.minidooray.gateway.domain.member.model.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "accountApi", url = "http://localhost:8081/accountapi")  // 외부 API URL을 입력
public interface AccountApiClient {

    // 사용자 회원가입 요청 member을 외부 api 전송하고 boolean 받아옴
    // 외부 API에서 회원가입을 처리하는 엔드포인트 http://localhost:8081/accountapi/users에게 보냄
    @PostMapping("/users")
    boolean registerUser(@RequestBody Member member);

    // 사용자 로그인 인증 요청(사용자 아이디, 비밀번호 전송)
    @PostMapping("/authenticate")  // 외부 API에서 로그인 인증을 처리하는 엔드포인트
    boolean authenticateUser(@RequestBody String id, @RequestBody String password);
}