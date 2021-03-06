//package org.fasttrackit.awesomechat.redis;
//
//import lombok.Builder;
//import lombok.Data;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.listener.PatternTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
//import javax.sound.midi.MidiMessage;
//import javax.sound.midi.Receiver;
//@Builder
//@Data
//@SpringBootApplication
//public class MessagingRedisApplication {
//    private static final Logger LOGGER = LoggerFactory.getLogger(MessagingRedisApplication.class,MessageListenerAdapter listenerAdapter);
//
//    @Bean
//    MessageListenerAdapter listenerAdapter(Receiver receiver) {
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }
//    @Bean
//    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory){
//
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.addMessageListener(listenerAdapter(), new PatternTopic("chat"));
//
//        return container;
//    }
//
//
//
//    @Bean
//    Receiver receiver() {
//        return new Receiver() {
//            @Override
//            public void send(MidiMessage message, long timeStamp) {
//            }
//            @Override
//            public void close() {
//
//            }
//        };
//    }
//
//    @Bean
//    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
//        return new StringRedisTemplate(connectionFactory);
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//
//        ApplicationContext ctx = SpringApplication.run(MessagingRedisApplication.class, args);
//
//        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
//        Receiver receiver = ctx.getBean(Receiver.class);
//
////        while (receiver.getCount() ==0) {
//        while (receiver.equals(0)) {
//
//            LOGGER.info("Sending message...");
//            template.convertAndSend("chat", "Hello from Redis!");
//            Thread.sleep(500L);
//        }
//
//        System.exit(0);
//    }
//}
