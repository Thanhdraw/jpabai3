package com.cybersoft.jpabai3.service;

import com.cybersoft.jpabai3.dto.request.CreateUserRequest;
import com.cybersoft.jpabai3.entity.UserEntity;
import com.cybersoft.jpabai3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity addUser(CreateUserRequest request){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(request.getPassword());
        userEntity.setEmail(request.getEmail());
        return userRepository.save(userEntity);
    }
}
