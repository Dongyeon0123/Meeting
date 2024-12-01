package com.example.demo.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String[] parts = username.split(":");  // 예: "nickname:1234"
        String nickname = parts[0];  // 닉네임
        String phoneNumberLast4 = parts[1];  // 전화번호 끝 4자리

        User user = userRepository.findByNicknameAndPhoneNumberEndingWith(nickname, phoneNumberLast4);
        
        if (user == null) {
            throw new UsernameNotFoundException("User not found with nickname and phone number last 4 digits: " + username);
        }
        
        return new org.springframework.security.core.userdetails.User(user.getNickname(), user.getPassword(), new ArrayList<>());
    }

}

