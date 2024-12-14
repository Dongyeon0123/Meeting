package com.example.demo.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private String nickname;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    // 생성자
    public CustomUserDetails(User user) {
        this.nickname = user.getNickname();
        this.password = user.getPassword();
        this.authorities = new ArrayList<>();  // 권한 설정 필요
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;  // 권한 정보를 설정
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nickname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // 계정 만료 여부
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // 계정 잠금 여부
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // 비밀번호 만료 여부
    }

    @Override
    public boolean isEnabled() {
        return true;  // 계정 활성화 여부
    }

    // 추가적인 getter 메서드
    public String getNickname() {
        return nickname;
    }
}
