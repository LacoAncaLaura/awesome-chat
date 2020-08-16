package org.fasttrackit.awesomechat.controller.rest;

import org.fasttrackit.awesomechat.domain.Chat;
import org.fasttrackit.awesomechat.service.ChatService;
import org.fasttrackit.awesomechat.transfer.chat.SaveChatRequest;
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
    public ResponseEntity<Chat> createChats(SaveChatRequest request) {

        Chat chat = chatService.createChat(request);
        return new ResponseEntity<>(chat, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Chat> getChat(@PathVariable long userId) {

        Chat chat = chatService.getChat(userId);
        return new ResponseEntity<>(chat, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Chat> updateChat(@PathVariable long id) {
        Chat chat = chatService.getChat(id);
        return new ResponseEntity<>(chat, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Chat> deleteChat(@PathVariable long id) {
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }}





