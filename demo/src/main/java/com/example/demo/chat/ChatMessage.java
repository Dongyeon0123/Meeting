package com.example.demo.chat;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "ChatMessages")
public class ChatMessage {

    @Id
    private String id;
    private String chatRoomId;  // 어떤 채팅방에 속한 메시지인지
    private String senderNickname;
    private String messageContent;
    private LocalDateTime timestamp;  // 메시지가 전송된 시간

    // 기본 생성자
    public ChatMessage() {}

    // 생성자
    public ChatMessage(String chatRoomId, String senderNickname, String messageContent) {
        this.chatRoomId = chatRoomId;
        this.senderNickname = senderNickname;
        this.messageContent = messageContent;
        this.timestamp = LocalDateTime.now();  // 현재 시간
    }

    // Getter 및 Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(String chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public String getSenderNickname() {
        return senderNickname;
    }

    public void setSenderNickname(String senderNickname) {
        this.senderNickname = senderNickname;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
