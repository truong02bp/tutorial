package com.mongodb.demo.service.impl;

import com.mongodb.demo.data.repositories.UserRepository;
import com.mongodb.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
