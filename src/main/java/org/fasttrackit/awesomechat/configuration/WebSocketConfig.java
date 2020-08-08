package org.fasttrackit.awesomechat.configuration;

import org.fasttrackit.awesomechat.AwesomeChatApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(new AbstractWebSocketHandler() {
            @Override
            public void afterConnectionEstablished(WebSocketSession session) throws Exception {
                super.afterConnectionEstablished(session);
            }
        }, "/web-socket");
    }
}
//public class WebSocketConfig  implements WebSocketMessageConfigurer {
//Simple Text Oriented Messaging Protocol (STOMP)
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
//        stompEndpointRegistry.addEndpoint("/ws").withSockJS();
//    }
//
//    @Override
//    public void configureClientInboundChannel(org.springframework.messaging.simp.config.ChannelRegistration channelRegistration) {
//
//    }
//
//    @Override
//    public void configureClientOutboundChannel(org.springframework.messaging.simp.config.ChannelRegistration channelRegistration) {
//
//    }
//
//    @Override
//    public void configureMessageBroker(org.springframework.messaging.simp.config.MessageBrokerRegistry messageBrokerRegistry) {
//        messageBrokerRegistry.setApplicationDestinationPrefixes("/app");
//        messageBrokerRegistry.enableSimpleBroker("/topic");
//    }
//}
