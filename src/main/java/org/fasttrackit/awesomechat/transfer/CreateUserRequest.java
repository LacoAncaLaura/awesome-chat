package org.fasttrackit.awesomechat.transfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateUserRequest {
private String loginName;
    @NotNull
    private String name;
    @NotNull
    private int age;
    @NotNull
    private String gender;
    private String imageURL;

}

