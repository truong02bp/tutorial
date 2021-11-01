package com.user.service.impl;

import com.user.data.dto.Image;
import com.user.data.dto.UserDto;
import com.user.data.entities.User;
import com.user.data.repositories.UserRepository;
import com.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Value("${host.image.service}")
    private String imageService;

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserDto getUserWithImage(Long id) {
        User user = getUserById(id);
        Image image = restTemplate.getForObject("http://" + imageService+ "/images/" + user.getImageId(), Image.class);
        return new UserDto(user, image);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
