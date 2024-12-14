package com.example.demo.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/create")
    public String createChatRoom(@RequestParam String roomName, @RequestParam String createdBy, Model model) {
        try {
            chatService.createChatRoom(roomName, createdBy);
            return "redirect:/chat/rooms";  // 리디렉션으로 수정
        } catch (Exception e) {
            model.addAttribute("error", "채팅방 생성 중 오류가 발생했습니다.");
            return "chat/error";  // 에러 페이지 경로 (뷰 템플릿에서 적절히 처리)
        }
    }

    @GetMapping("/rooms")
    public String getChatRooms(Model model) {
        List<ChatRoom> chatRooms = chatService.getAllChatRooms();
        model.addAttribute("chatRooms", chatRooms);
        return "chat/rooms";  // 채팅방 목록 화면
    }

    // 특정 채팅방의 메시지들 보기
    @GetMapping("/room/{id}")
    public String getMessagesForRoom(@PathVariable String id, Model model) {
        List<ChatMessage> messages = chatService.getMessagesForRoom(id);
        model.addAttribute("messages", messages);
        return "chat/room";  // 특정 채팅방 화면
    }

    // 메시지 보내기
    @PostMapping("/send/{chatRoomId}")
    public String sendMessage(@PathVariable String chatRoomId, @RequestParam String senderNickname, @RequestParam String messageContent) {
        chatService.sendMessage(chatRoomId, senderNickname, messageContent);
        return "/chat/room/" + chatRoomId;
    }
}
