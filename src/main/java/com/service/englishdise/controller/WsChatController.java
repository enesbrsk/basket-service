package com.service.englishdise.controller;

import com.service.englishdise.dto.request.MessageRequest;
import com.service.englishdise.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WsChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping("/test")
    public String chatPage() {
        return "chater"; // chat.html sayfasını döndürüyoruz
    }

    @MessageMapping("/private")
    public void chatEndpoint(@Payload MessageRequest messageRequest) {
        messagingTemplate.convertAndSendToUser(messageRequest.getReceiver(),
                "/specific", messageRequest);
    }

}
