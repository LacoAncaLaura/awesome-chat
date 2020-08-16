package org.fasttrackit.awesomechat.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Chat {
    @Id
    private long userId;

    private String sender;

    private MessageType type;

    private String content;


    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}
