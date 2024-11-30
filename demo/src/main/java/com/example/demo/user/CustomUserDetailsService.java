package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; // MongoDB에서 사용자 정보를 가져올 리포지토리

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        // nickname으로 User를 찾아옵니다.
        User user = userRepository.findByNickname(nickname);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with nickname: " + nickname);
        }
        return user; // User 클래스는 UserDetails를 구현하므로 바로 반환
    }
}
