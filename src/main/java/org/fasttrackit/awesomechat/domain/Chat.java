package org.fasttrackit.awesomechat.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Chat {
    private MessageType type;
    private String content;
    private String sender;

    public enum MessageType{
        CHAT,
        JOIN,
        LEAVE
    }
}
