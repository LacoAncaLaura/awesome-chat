package org.fasttrackit.awesomechat.service;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.fasttrackit.awesomechat.domain.User;
import org.fasttrackit.awesomechat.exception.ResourceNotFoundException;
import org.fasttrackit.awesomechat.persistance.UserRepository;
import org.fasttrackit.awesomechat.transfer.user.CreateUserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;
    @Autowired
    public UserService(UserRepository userRepository,ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }
    public User createUser(CreateUserRequest request) {
//            System.out.println("Creating new account: " + request);
        LOGGER.info("Creating new user{}", request);
        User user = objectMapper.convertValue(request,User.class);
        return userRepository.save(user);
    }
    public User getUser(long id){
        LOGGER.info("Finding user{}" , id);
//        Lambda
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User" + id + "not found"));

    }
    public User updateUser(long id, CreateUserRequest request){
        LOGGER.info("Updating userAccount{}: {}", id , request);
        User user = getUser(id);
        BeanUtils.copyProperties(request, user);
        return userRepository.save(user);
    }
    public void deleteUser(long id){
        LOGGER.info("Deleting user{}" , id);
        userRepository.deleteById(id);
    }
}