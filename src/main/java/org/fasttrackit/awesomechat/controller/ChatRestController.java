package org.fasttrackit.awesomechat.controller;

import org.fasttrackit.awesomechat.domain.Chat;
import org.fasttrackit.awesomechat.service.ChatService;
import org.fasttrackit.awesomechat.transfer.chat.CreateChatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/chats")
public class ChatRestController {
    private final ChatService chatService;

    @Autowired
    public ChatRestController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity<Chat> createChats(CreateChatRequest request) {
        Chat chat = chatService.createChat(request);
        return new ResponseEntity<>(chat, HttpStatus.CREATED);
    }

    @GetMapping("/{id")
    public ResponseEntity<Chat> getChat(@PathVariable String sender) {
        Chat chat = chatService.getChat(sender);
        return new ResponseEntity<>(chat, HttpStatus.OK);
    }
}

