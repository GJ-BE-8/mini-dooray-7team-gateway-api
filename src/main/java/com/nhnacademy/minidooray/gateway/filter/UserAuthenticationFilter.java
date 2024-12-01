package com.nhnacademy.minidooray.gateway.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.minidooray.gateway.domain.member.model.Member;
import com.nhnacademy.minidooray.gateway.domain.member.model.RedisMember;
import com.nhnacademy.minidooray.gateway.service.account.MemberService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class UserAuthenticationFilter extends OncePerRequestFilter {

    private RedisTemplate<String, Object> sessionRedisTemplate;

    private MemberService memberService;



    public UserAuthenticationFilter(RedisTemplate<String, Object> sessionRedisTemplate, MemberService memberService) {
        this.sessionRedisTemplate = sessionRedisTemplate;
        this.memberService = memberService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //TODO
        String sessionId = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("SESSIONID".equals(cookie.getName())) {
                    sessionId = cookie.getValue();
                }
            }
        }
        if (sessionId != null) {
            // Redis에서 인증 정보 가져오기
            Object o = sessionRedisTemplate.opsForValue().get(sessionId);

            String id = (String) o; // 여기서 id가 null인지 확인

            Member member = memberService.getMember(id);
            RedisMember redisMember = new RedisMember(member);
            Authentication auth = new PreAuthenticatedAuthenticationToken(redisMember, null, redisMember.getAuthorities());
            auth.setAuthenticated(true);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        // 다음 필터로 요청 전달
        filterChain.doFilter(request, response);
    }
}
