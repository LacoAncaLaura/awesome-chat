package org.fasttrackit.awesomechat;

import org.fasttrackit.awesomechat.domain.User;
import org.fasttrackit.awesomechat.exception.ResourceNotFoundException;
import org.fasttrackit.awesomechat.service.UserService;
import org.fasttrackit.awesomechat.transfer.SaveUserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


@SpringBootTest
class AwesomeChatApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void createUser_whenValidRequest_thenReturnCreatedProduct() {createUser(); }

    private User createUser() {
        SaveUserRequest request = new SaveUserRequest();
        request.setName("George");
        request.setLoginName("Gigi");
        request.setAge(20);
        request.setGender(0);
        request.setImageURL("download.jpg");
        User user = userService.createUser(request);
        assertThat(user, notNullValue());
        assertThat(user.getId(), greaterThan(0L));
        assertThat(user.getName(), is(request.getName()));
        assertThat(user.getLoginName(), is(request.getLoginName()));
        assertThat(user.getAge(), is(request.getAge()));
        assertThat(user.getGender(), is(request.getGender()));
        assertThat(user.getImageURL(), is(request.getImageURL()));
        return user;
    }

    @Test
    void createUser_whenMissingMandatoryDetails_theThrowException() {
        SaveUserRequest request = new SaveUserRequest();
        try {
            User user = userService.createUser(request);
        } catch (Exception e) {
            assertThat("Missing mandatory details", e instanceof ConstraintViolationException);
        }
    }

    @Test
    void getUser_whenExistingAccount_thenReturnAccount() {
        User user = createUser();
        User response = userService.getUser(user.getId());
    }

    @Test
    void getUser_whenNonExistingAccount_thenThrowNotFoundException() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> userService.getUser(0));
    }
}
