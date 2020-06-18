package org.fasttrackit.awesomechat.service;

import org.fasttrackit.awesomechat.domain.User;
import org.fasttrackit.awesomechat.persistance.UserRepository;
import org.fasttrackit.awesomechat.transfer.SaveUserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository ;

    public UserService(UserRepository userRepository){this.userRepository = userRepository;}
        public User createUser (SaveUserRequest request){
            System.out.println("Creating new account: " + request);
            User user = new User();
            user.setLoginName(request.getLoginName());
            user.setName(request.getName());
            user.setAge(request.getAge());
            user.setGender(request.getGender());
            user.setImageURL(request.getImageURL());
            return userRepository.save(user);
    }
}