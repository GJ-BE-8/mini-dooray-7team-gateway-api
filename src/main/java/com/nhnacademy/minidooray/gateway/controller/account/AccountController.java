package com.nhnacademy.minidooray.gateway.controller.account;

import com.nhnacademy.minidooray.gateway.domain.member.model.Member;
import com.nhnacademy.minidooray.gateway.domain.member.request.login.MemberLoginDto;
import com.nhnacademy.minidooray.gateway.domain.member.request.register.MemberCreateDto;
import com.nhnacademy.minidooray.gateway.feignclient.AccountApiClient;

//import com.nhnacademy.minidooray.gateway.feign.AuthServiceClient;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//인가 인증용 입력 데이터 외부 API에 전달 및 기타용 controller

@Controller
@Slf4j
@RequestMapping("/login")
public class AccountController {

    @Autowired
    private AccountApiClient accountApiClient; // FeignClient를 사용하여 외부 API와 통신

    // 로그인 폼 제출 처리 security로 대부분 대체 예정
    @PostMapping("/signin")
    public String signIn(@ModelAttribute MemberLoginDto memberLoginDto, HttpSession session) {
        //todo 외부 AccountApi에 데이터 베이스 요청후에 security로 전달.
        //로그인 로직 처리 / 로그인 성공 또는 실패 시 리디렉션 등
//        boolean isAuthenticated = accountApiClient.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
//        athentication.context().



        //인증 요청 securityconfig가 담당

        return "redirect:/";
    }

    // 회원가입 폼 제출 처리
    @PostMapping("/signup")
    public String signUp(@ModelAttribute MemberCreateDto memberCreateDto, HttpSession session) {

        // 회원가입
        Member member = new Member();
        member.setId(memberCreateDto.getId());
        member.setPwd(memberCreateDto.getPwd());
        member.setEmail(memberCreateDto.getEmail());

        //todo 외부 AccountApi에 member 전송(ID 중복 여부 파악 및 데이터 베이스 업데이트를 위해)
        //외부 api에서 중복 없을시 true 반환
        boolean result = accountApiClient.registerUser(member);


        //가입 성공 했다면 project로 이동, 실패시 다시 login으로 이동
        if(result) {
            return "redirect:/project";
        }

        //가입이후 home으로 이동
        return "redirect:/login";
    }

    //TemplateEngine(Thymeleaf) 사용하여 login 화면을 표시
    @GetMapping
    public String loginPage() {
        return "login";
    }
}
