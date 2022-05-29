package com.multi_thread_async;

import com.multi_thread_async.entities.User;
import com.multi_thread_async.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class Controller {

    private UserService userService;

    @GetMapping
    public ResponseEntity<Integer> test() {
        List<User> users = userService.getUser();
        return ResponseEntity.ok(users.size());
    }

    @GetMapping("/async")
    public ResponseEntity<Integer> test2() throws ExecutionException, InterruptedException {
        List<User> users = userService.getUserAsync();
        return ResponseEntity.ok(1);
    }
}
