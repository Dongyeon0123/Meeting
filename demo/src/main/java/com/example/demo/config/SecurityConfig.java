package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers("/register/login", "/register/signup", "/").permitAll()  // 로그인, 회원가입, 홈 페이지는 누구나 접근 가능
                .anyRequest().authenticated()  // 그 외 요청은 인증 필요
            .and()
            .formLogin()
                .loginPage("/register/login")  // 커스터마이징된 로그인 페이지로 이동
                .loginProcessingUrl("/register/login")  // 로그인 폼 처리 URL 설정
                .defaultSuccessUrl("/home", true)  // 로그인 성공 후 /home으로 리디렉트
                .failureUrl("/register/login?error=true")  // 로그인 실패 시 /login?error=true로 리디렉트
                .permitAll()
            .and()
            .logout()
                .permitAll()  // 로그아웃 페이지도 누구나 접근 가능
            .and()
            .csrf().disable();  // CSRF 보호 비활성화

        return http.build();
    }
}
