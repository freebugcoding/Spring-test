package com.democto.kubernetes.controller;

import com.democto.kubernetes.dto.MessageDto;
import com.democto.kubernetes.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DummyController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<?> getMessages(){
        return new ResponseEntity<>(messageService.getAllMessages(), HttpStatus.OK);
    }

    @PostMapping("/")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<?> saveMessage(@RequestBody MessageDto messageDto){
        return new ResponseEntity<>(messageService.saveMessage(messageDto), HttpStatus.CREATED);
    }
}
