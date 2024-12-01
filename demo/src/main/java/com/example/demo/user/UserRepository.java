package com.example.demo.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
	// 닉네임으로 사용자 검색
    User findByNickname(String nickname);
	
	User findByNicknameAndPhoneNumberEndingWith(String nickname, String phoneNumberLast4);
}
