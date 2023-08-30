package com.service.englishdise.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MessageRequest {
    private String content;
    private String receiver;
    private String sender;
}
