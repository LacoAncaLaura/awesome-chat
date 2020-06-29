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
    void createUser_whenValidRequest_thenReturnCreatedProduct() {
        createUser();
    }

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
    void getUser_whenExistingAccount_thenReturnAccount() {
        User user = createUser();
        User response = userService.getUser(user.getId());
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
    void getUser_whenNonExistingAccount_thenThrowNotFoundException() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> userService.getUser(0));
    }

    @Test
    void updateUser_whenValidDetailsChange_thenUpdatingUserAccount(){
        User user = createUser();
        SaveUserRequest request = new SaveUserRequest();
        request.setName(user.getName());
        request.setLoginName(user.getLoginName());
        request.setAge(user.getAge());
        request.setGender(user.getGender());
        request.setImageURL(user.getImageURL());
        User updateUser = userService.updateUser(user.getId(),request);
        assertThat(updateUser, notNullValue());
        assertThat(updateUser.getId(), is(user.getId()));
        assertThat(updateUser.getName(), is(user.getName()));
        assertThat(updateUser.getLoginName(), is(user.getLoginName()));
        assertThat(updateUser.getAge(), is(user.getAge()));
        assertThat(updateUser.getGender(), is(user.getGender()));
        assertThat(updateUser.getImageURL(), is(user.getImageURL()));
    }
    @Test
    void deleteUser_whenExistingUserAccount_theUserAccountDoseNotExistAnymore(){
        User user = createUser();
        userService.deleteUser(user.getId());
        Assertions.assertThrows(ResourceNotFoundException.class, () -> userService.getUser(1));
    }
}
