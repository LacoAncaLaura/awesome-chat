package org.fasttrackit.awesomechat.transfer.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fasttrackit.awesomechat.domain.Chat;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateChatRequest {
    @Id
    private String sender;
    @NotNull
    private Chat.MessageType type;
    @NotNull
    private String content;
}
