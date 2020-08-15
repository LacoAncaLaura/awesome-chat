package org.fasttrackit.awesomechat.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.*;



@Configuration
@EnableWebSocketMessageBroker
public abstract class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
//        webSocketHandlerRegistry.addHandler(new AbstractWebSocketHandler() {
//            @Override
//            public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//                super.afterConnectionEstablished(session);
//            }
//        }, "/web-socket");
//    }

    //Simple Text Oriented Messaging Protocol (STOMP)
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        //        RabbitMQ
        config.enableSimpleBroker("/topic");
        config.enableStompBrokerRelay("/topic")
                .setRelayHost("localhost")
                .setRelayPort(8086)
                .setClientLogin("guest")
                .setClientPasscode("guest");

        config.setApplicationDestinationPrefixes("/app");
    }
}

