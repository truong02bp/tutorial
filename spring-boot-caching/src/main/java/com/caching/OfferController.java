package com.caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;

@RestController
public class OfferController {

    @Autowired
    private OfferService channelService;

    @GetMapping("/")
    public ResponseEntity<Set<String>> getAll() {
        return ResponseEntity.ok(channelService.findAll());
    }
}
