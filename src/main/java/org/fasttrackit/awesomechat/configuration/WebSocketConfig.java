package org.fasttrackit.awesomechat.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.*;



@Configuration
@EnableWebSocketMessageBroker
public abstract class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    //Simple Text Oriented Messaging Protocol (STOMP)
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/ws").withSockJS();
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        //        RabbitMQ
        config.enableSimpleBroker("/topic");
        config.enableStompBrokerRelay("/topic")
                .setRelayHost("localhost")
                .setRelayPort(63342)
                .setClientLogin("guest")
                .setClientPasscode("guest");

        config.setApplicationDestinationPrefixes("/app");
    }
}

