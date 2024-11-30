package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // nickname으로 유저를 찾는 메서드
    public User findUserByNickname(String nickname) {
        return userRepository.findByNickname(nickname);  // nickname을 기준으로 유저를 찾음
    }

    // 유저를 저장하는 메서드
    public User saveUser(User user) {
        return userRepository.save(user);  // 유저 저장
    }
}
