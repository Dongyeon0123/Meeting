package com.example.demo.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    // nickname을 기준으로 유저를 찾는 메서드
    User findByNickname(String nickname);
}
