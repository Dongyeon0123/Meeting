package com.example.demo.chat;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    // 특정 채팅방의 모든 메시지 찾기
    List<ChatMessage> findByChatRoomId(String chatRoomId);
}
