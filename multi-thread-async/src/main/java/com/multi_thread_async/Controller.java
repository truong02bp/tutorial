package com.multi_thread_async;

import com.multi_thread_async.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/user")
public class Controller {

    @Autowired
    UserService userService;

    @GetMapping
    public void test() throws ExecutionException, InterruptedException {
        userService.getUser();
    }

    @PostMapping
    public void test2() throws ExecutionException, InterruptedException {
        userService.getUserAsync();
    }
}
