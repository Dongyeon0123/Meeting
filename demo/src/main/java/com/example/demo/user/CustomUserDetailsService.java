package com.example.demo.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 기존 Username 기반 로그인 로직 (사용하지 않을 경우 생략 가능)
        throw new UsernameNotFoundException("Default method not supported. Use loadUserByNicknameAndPhoneNumber.");
    }

    public UserDetails loadUserByNicknameAndPhoneNumber(String nickname, String phoneNumber) throws UsernameNotFoundException {
        // repository에서 닉네임과 전화번호를 기준으로 사용자 조회
        User user = userRepository.findByNicknameAndPhoneNumber(nickname, phoneNumber);

        // 사용자 정보가 없으면 예외를 던짐
        if (user == null) {
            throw new UsernameNotFoundException("User not found with nickname: " + nickname + " and phone number: " + phoneNumber);
        }

        return user;  // UserDetails를 구현한 User 객체 반환
    }
}
