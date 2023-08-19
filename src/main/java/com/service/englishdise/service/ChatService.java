package com.service.englishdise.service;

import com.service.englishdise.model.Message;
import com.service.englishdise.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ChatService {

    private SimpMessagingTemplate messagingTemplate;
    private final MessageRepository messageRepository;

    @Autowired
    public ChatService( MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void addMessage(String sender, String receiver, Message message) {
        Message messageEntity = new Message();
        messageEntity.setSender(sender);
        messageEntity.setReceiver(receiver);
        messageEntity.setContent(message.getContent());
        messageEntity.setTimestamp(LocalDateTime.now());
        messageRepository.save(messageEntity);

        messagingTemplate.convertAndSendToUser(receiver, "/queue/messages", message);
    }

    public List<Message> getConversation(String sender, String receiver) {
        return messageRepository.findBySenderAndReceiverOrSenderAndReceiverOrderByTimestampAsc(
                sender, receiver, receiver, sender);
    }

}
