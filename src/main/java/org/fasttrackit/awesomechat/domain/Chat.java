package org.fasttrackit.awesomechat.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Chat {
    @Id
    private long userId;
    @NotNull
    private String sender;
    @NotNull
    private MessageType type;
    @NotNull
    private String content;


    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}
