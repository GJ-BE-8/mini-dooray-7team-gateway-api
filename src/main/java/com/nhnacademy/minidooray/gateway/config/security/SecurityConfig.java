package com.nhnacademy.minidooray.gateway.config.security;

import com.nhnacademy.minidooray.gateway.filter.UserAuthenticationFilter;
import com.nhnacademy.minidooray.gateway.service.account.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.lang.reflect.Method;

@Configuration
@Slf4j
public class SecurityConfig {
    @Autowired
    private final RedisTemplate<String, Object> sessionRedisTemplate;


    public SecurityConfig(RedisTemplate<String, Object> sessionRedisTemplate) {
        this.sessionRedisTemplate = sessionRedisTemplate;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, MemberService memberService) throws Exception {


        http.addFilterBefore(new UserAuthenticationFilter(sessionRedisTemplate, memberService), UsernamePasswordAuthenticationFilter.class);

        http.csrf(AbstractHttpConfigurer::disable);
        // 인증
        // http.authenticationProvider(authenticationProvider(passwordEncoder, ))

        // 로그인 설정
        http.formLogin(formLogin ->
                formLogin.loginPage("/login")
                        .permitAll()
                        .usernameParameter("id")
                        .passwordParameter("password")
                        .loginProcessingUrl("/login/process"))
                // 로그아웃 설정
                .logout(logout ->
                        logout.logoutUrl("/logout").permitAll());


        // 요청 권한 설정
        http.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/logout").permitAll()

                        .requestMatchers(HttpMethod.POST, "/users").permitAll()
                        .requestMatchers(HttpMethod.POST, "/users/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/users/{userId}").permitAll()
                        .requestMatchers("/projects/**").permitAll()
                        .anyRequest().permitAll()


//
//                        // 모든 사용자가 프로젝트를 생성할 수 있도록 설정
//                        .requestMatchers(HttpMethod.POST, "/projects").hasAnyRole("USER") // 모든 사용자
//
//                        // 프로젝트 관련 권한
//                        .requestMatchers(HttpMethod.GET, "/projects").hasAnyRole("USER") // 모든 사용자
//                        .requestMatchers(HttpMethod.GET, "/projects/{project_id}").hasAnyRole("USER") // 모든 사용자
//                        .requestMatchers(HttpMethod.POST, "/projects/{project_id}/users").hasRole("ADMIN") // Project Admin만
//
//                        // 태스크 관련 권한
//                        .requestMatchers(HttpMethod.POST, "/projects/{project_id}/tasks").hasAnyRole("ADMIN", "USER") // Project Admin 및 멤버
//                        .requestMatchers(HttpMethod.PUT, "/projects/{project_id}/tasks/{task_id}").hasAnyRole("ADMIN", "USER") // 수정
//                        .requestMatchers(HttpMethod.DELETE, "/projects/{project_id}/tasks/{task_id}/delete").hasAnyRole("ADMIN", "USER") // 삭제
//                        .requestMatchers(HttpMethod.GET, "/projects/{project_id}/tasks").hasAnyRole("ADMIN", "USER") // 목록 조회
//                        .requestMatchers(HttpMethod.GET, "/projects/{project_id}/tasks/{task_id}").hasAnyRole("ADMIN", "USER") // 상세 조회
//
//                        // 태그 및 마일스톤 관련 권한
//                        .requestMatchers(HttpMethod.POST, "/projects/{project_id}/tasks/{task_id}/tags").hasAnyRole("ADMIN", "USER") // 태그 등록
//                        .requestMatchers(HttpMethod.PUT, "/projects/{project_id}/tasks/{task_id}/tags/{tag_id}").hasAnyRole("ADMIN", "USER") // 태그 수정
//                        .requestMatchers(HttpMethod.DELETE, "/projects/{project_id}/tasks/{task_id}/tags/{tag_id}/delete").hasAnyRole("ADMIN", "USER") // 태그 삭제
//                        .requestMatchers(HttpMethod.POST, "/projects/{project_id}/tasks/{task_id}/milestone").hasAnyRole("ADMIN", "USER") // 마일스톤 등록
//                        .requestMatchers(HttpMethod.GET, "/projects/{project_id}/tasks/{task_id}/milestone").hasAnyRole("ADMIN", "USER") // 마일스톤 조회
//                        .requestMatchers(HttpMethod.DELETE, "/projects/{project_id}/tasks/{task_id}/milestone/delete").hasAnyRole("ADMIN", "USER") // 마일스톤 삭제
        );

        return http.build();
    }
}

