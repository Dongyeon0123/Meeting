package com.example.demo.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
	// nickname으로 유저를 찾는 메서드
    User findByNickname(String nickname);

    // nickname과 전화번호로 유저를 찾는 메서드
    User findByNicknameAndPhoneNumber(String nickname, String phoneNumber);
}
