package org.fasttrackit.awesomechat.controller;

import org.fasttrackit.awesomechat.domain.Chat;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import static javax.swing.UIManager.put;

@Controller
public class ChatController {
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Chat register(@Payload Chat chat, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getContentType();
        put("loginName", chat.getSender());
        return chat;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Chat sendMessage(@Payload Chat chat) {
        return chat;
    }


}
