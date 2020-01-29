package com.democto.kubernetes.service;

import com.democto.kubernetes.dto.MessageDto;
import com.democto.kubernetes.entity.Message;
import com.democto.kubernetes.repo.MessageRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepo messageRepo;

    @Override
    public List<MessageDto> getAllMessages() {
        return messageRepo.findAll().stream().map(message -> {
            MessageDto messageDto = new MessageDto();
            BeanUtils.copyProperties(message, messageDto);
            return messageDto;
        }).collect(Collectors.toList());
    }

    @Override
    public MessageDto saveMessage(MessageDto messageDto) {
        Message message = new Message();
        BeanUtils.copyProperties(messageDto, message);
        message = messageRepo.save(message);
        messageDto.setId(message.getId());
        return messageDto;
    }
}
