package org.fasttrackit.awesomechat.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Chat {
    @Id
    private String sender;
    private MessageType type;
    private String content;


    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}
