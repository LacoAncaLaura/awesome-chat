package org.fasttrackit.awesomechat.controller;

import lombok.Builder;
import lombok.Data;
import org.fasttrackit.awesomechat.domain.Chat;
import org.fasttrackit.awesomechat.domain.User;
import org.fasttrackit.awesomechat.service.ChatService;
import org.fasttrackit.awesomechat.service.UserService;
import org.fasttrackit.awesomechat.transfer.CreateChatRequest;
import org.fasttrackit.awesomechat.transfer.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Builder
@Data
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

