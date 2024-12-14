package com.example.demo.chat;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ChatRooms")
public class ChatRoom {

    @Id
    private String id;
    private String roomName;
    private String createdBy;

    // 기본 생성자
    public ChatRoom() {}

    // 생성자
    public ChatRoom(String roomName, String createdBy) {
        this.roomName = roomName;
        this.createdBy = createdBy;
    }

    // Getter 및 Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
