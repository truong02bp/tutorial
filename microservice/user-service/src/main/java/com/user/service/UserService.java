package com.user.service;

import com.user.data.dto.UserDto;
import com.user.data.entities.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    UserDto getUserWithImage(Long id);

    List<User> findAll();

}
