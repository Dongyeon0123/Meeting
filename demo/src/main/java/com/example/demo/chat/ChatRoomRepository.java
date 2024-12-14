package com.example.demo.chat;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
    // 채팅방 이름으로 채팅방 검색
    ChatRoom findByRoomName(String roomName);
}
