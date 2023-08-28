package com.service.englishdise.controller;

import com.service.englishdise.model.Message;
import com.service.englishdise.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    private final ChatService chatService;

    @Autowired
    public ChatController( ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/test")
    public String chatPage() {
        return "chater"; // chat.html sayfasını döndürüyoruz
    }


    @MessageMapping("/private")
    public void chatEndpoint(@Payload WsMessage wsMessage) {

        messagingTemplate.convertAndSendToUser(wsMessage.getReciever(),
                "/specific", wsMessage);



    }
}
