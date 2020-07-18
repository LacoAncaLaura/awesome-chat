package org.fasttrackit.awesomechat.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.fasttrackit.awesomechat.domain.User;
import org.fasttrackit.awesomechat.service.UserService;
import org.fasttrackit.awesomechat.transfer.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Builder
@Data
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

        private final UserService userService;

        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
        }

        @PostMapping
        public ResponseEntity<User> createUsers(CreateUserRequest request) {
            User user = userService.createUser(request);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }

        @GetMapping("/{id")
        public ResponseEntity<User> getUser(@PathVariable long id) {
            User user = userService.getUser(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

