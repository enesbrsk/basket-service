package com.service.englishdise.repository;

import com.service.englishdise.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findBySenderAndReceiverOrSenderAndReceiverOrderByTimestampAsc(
            String sender, String receiver, String receiver2, String sender2);
}