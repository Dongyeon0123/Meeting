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

    // nickname과 phoneNumber 전체로 유저를 찾는 메서드
    public User findUserByNicknameAndPhoneNumber(String nickname, String phoneNumber) {
        System.out.println("DB 조회 - 닉네임: " + nickname + ", 전화번호: " + phoneNumber);
        User user = userRepository.findByNicknameAndPhoneNumber(nickname, phoneNumber);
        if (user != null) {
            System.out.println("유저 정보: " + user);
        } else {
            System.out.println("해당 사용자 없음");
        }
        return user;
    }

    // 유저를 저장하는 메서드
    public User saveUser(User user) {
        return userRepository.save(user);  // 유저 저장
    }
}
