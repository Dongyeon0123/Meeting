package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import com.example.demo.user.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }
    
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        CustomAuthenticationProvider provider = new CustomAuthenticationProvider(customUserDetailsService);
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                   .authenticationProvider(provider)
                   .build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                // favicon.ico 요청과 로그인, 회원가입, 홈 등은 인증 없이 접근 가능
                .requestMatchers("/register/login", "/register/signup", "/favicon.ico", "/chat/**").permitAll()
                .anyRequest().permitAll()
            .and()
            .formLogin()
                .loginPage("/register/login")  // 로그인 페이지
                .loginProcessingUrl("/login")  // 로그인 요청 처리 URL
                .defaultSuccessUrl("/home", true)  // 로그인 성공 시 리다이렉트할 URL
                .failureUrl("/register/login?error=true")  // 로그인 실패 시
                .permitAll()
            .and()
            .logout()
                .permitAll()
            .and()
            .rememberMe()
                .key("uniqueRandomKeyForRememberMeFunctionality")
                .tokenValiditySeconds(86400)
            .and()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .invalidSessionUrl("/register/login?sessionExpired=true")
                .maximumSessions(1)
                .expiredUrl("/register/login?sessionExpired=true");
        return http.build();
    }
}
