package com.service.englishdise.controller;

import com.service.englishdise.model.Message;
import com.service.englishdise.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class ChatController {
    private SimpMessagingTemplate messagingTemplate;
    private final ChatService chatService;

    @Autowired
    public ChatController( ChatService chatService) {

        this.chatService = chatService;
    }

    @MessageMapping("/init")
    @SendTo("/queue/init")
    public List<Message> initializeChat(Message message, Principal principal) {
        String sender = principal.getName();
        String receiver = message.getReceiver();

        return chatService.getConversation(sender, receiver);
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public void sendMessage(Message message, Principal principal) {
        String sender = principal.getName();
        String receiver = message.getReceiver();

        chatService.addMessage(sender, receiver, message);

        messagingTemplate.convertAndSendToUser(receiver, "/queue/messages", message);
    }
}
