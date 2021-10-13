package com.multi_thread_async.services;

import com.multi_thread_async.entities.Image;
import com.multi_thread_async.entities.User;
import com.multi_thread_async.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void insert() {
        int i=0;
        List<User> users = new ArrayList<>();
        while (i <= 200000) {
            if (i%1000 == 0) {
                userRepository.saveAll(users);
                users.clear();
            }
            User user = User.builder()
                    .username(String.valueOf(i)).password("a")
                    .email("truong02.bp@gmail.com").name("aaa").address("bbb")
                    .image(Image.builder().name("abc").url("def").build()).build();
            users.add(user);
            i++;
        }
    }

    public List<User> getUser() {
        long start = System.currentTimeMillis();
        List<User> users = userRepository.findAll();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return users;
    }

    @Async
    public List<User> getUserAsync() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture<List<User>> users = CompletableFuture.completedFuture(userRepository.findAll());
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return users.get();
    }

}
