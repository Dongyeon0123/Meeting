package com.example.demo.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChatService(ChatRoomRepository chatRoomRepository, ChatMessageRepository chatMessageRepository) {
        this.chatRoomRepository = chatRoomRepository;
        this.chatMessageRepository = chatMessageRepository;
    }

    public void createChatRoom(String roomName, String createdBy) {
        if (roomName == null || roomName.trim().isEmpty()) {
            throw new IllegalArgumentException("Room name cannot be empty");
        }
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setRoomName(roomName);
        chatRoom.setCreatedBy(createdBy);
        
        chatRoomRepository.save(chatRoom);
    }




    // 채팅방 목록 가져오기
    public List<ChatRoom> getAllChatRooms() {
        return chatRoomRepository.findAll();
    }

    // 특정 채팅방의 메시지 가져오기
    public List<ChatMessage> getMessagesForRoom(String roomId) {
        return chatMessageRepository.findByChatRoomId(roomId);
    }

    // 메시지 보내기
    public void sendMessage(String chatRoomId, String senderNickname, String messageContent) {
        ChatMessage chatMessage = new ChatMessage(chatRoomId, senderNickname, messageContent);
        chatMessageRepository.save(chatMessage);
    }
}
