package com.service.englishdise.controller;

import com.service.englishdise.dto.request.MessageRequest;
import com.service.englishdise.model.Message;
import com.service.englishdise.service.ChatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }


    @PostMapping("/getHistory")
    public List<Message> getChatHistory(@RequestBody MessageRequest messageRequest) {
        var data = chatService.getConversation(messageRequest.getSender(), messageRequest.getReceiver());
        return data;
    }


}
