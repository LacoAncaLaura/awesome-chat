package org.fasttrackit.awesomechat.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.fasttrackit.awesomechat.domain.Chat;
import org.fasttrackit.awesomechat.exception.ResourceNotFoundException;
import org.fasttrackit.awesomechat.persistance.ChatRepository;
import org.fasttrackit.awesomechat.transfer.chat.CreateChatRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatService.class);
    private final ChatRepository chatRepository;
    private final UserService userService;
    private final ObjectMapper objectMapper;

    @Autowired
    public ChatService(ChatRepository chatRepository, UserService userService , ObjectMapper objectMapper) {
        this.chatRepository = chatRepository;
        this.userService = userService;
        this.objectMapper = objectMapper;
    }

    public Chat createChat(CreateChatRequest request) {
        LOGGER.info("Creating new chat{}", request);
        Chat chat = objectMapper.convertValue(request,Chat.class);
        return chatRepository.save(chat);

    }

    public Chat getChat(String sender) {
        LOGGER.info("Find sender{}", sender);
        return chatRepository.findById(sender)
                .orElseThrow(() -> new ResourceNotFoundException("Chat " + sender + "not found"));
    }

    public Chat updateChat(String sender, CreateChatRequest request) {
        LOGGER.info("Updating chat {}: {} ", sender, request);
        Chat chat = getChat(sender);
        BeanUtils.copyProperties(request, chat);
        return chatRepository.save(chat);
    }

    public void deleteChat(String sender) {
        LOGGER.info("Deleting chat{}", sender);
        chatRepository.deleteById(sender);
    }

}
