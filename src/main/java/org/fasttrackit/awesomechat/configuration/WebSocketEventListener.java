//package org.fasttrackit.awesomechat.configuration;
//
//
//import org.fasttrackit.awesomechat.domain.Chat;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import org.springframework.context.event.EventListener;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.simp.SimpMessageSendingOperations;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.stereotype.Component;
//import javax.sql.ConnectionEvent;
//
//@Component
//public class WebSocketEventListener {
//    public static final Logger LOGGER = LoggerFactory.getLogger(WebSocketEventListener.class);
//
//    private SimpMessageSendingOperations messagingTemplate;
//
//    @EventListener
//    public void handleWebSocketConnect(ConnectionEvent event){
//        LOGGER.info("Received a new connection");
//    }
//    @EventListener
//    public void handleWebSocketDisconnect(DisconnectionEvent event){
//        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap((Message<?>) event);
//        String loginName = headerAccessor.getContentType().getParameter("loginName");
//        if (loginName != null){
//            LOGGER.info("User disconnected" + loginName);
//            Chat chat = new Chat();
//            chat.setType(Chat.MessageType.LEAVE);
//            chat.setSender(loginName);
//            messagingTemplate.convertAndSend("/topic/public", chat);
//        }
//    }
//}
