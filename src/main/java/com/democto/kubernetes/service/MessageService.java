package com.democto.kubernetes.service;

import com.democto.kubernetes.dto.MessageDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MessageService {
    List<MessageDto> getAllMessages();
    MessageDto saveMessage( MessageDto messageDto);
    }
