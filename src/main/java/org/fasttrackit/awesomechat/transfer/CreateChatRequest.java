package org.fasttrackit.awesomechat.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fasttrackit.awesomechat.domain.Chat;

import javax.validation.constraints.NotNull;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateChatRequest {
    @NotNull
    private Chat.MessageType type;
    @NotNull
    private String content;
    @NotNull
    private String sender;
}
