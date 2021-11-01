package com.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    private String userServiceFallBack() {
        return "User service is taking longer than expected, please try again later";
    }

    @GetMapping("/imageServiceFallBack")
    private String imageServiceFallBack() {
        return "User service is taking longer than expected, please try again later";
    }
}
