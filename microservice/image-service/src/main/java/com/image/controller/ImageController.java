package com.image.controller;

import com.image.data.entities.Image;
import com.image.data.repositories.ImageRepository;
import com.image.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;
    private final ImageRepository imageRepository;

    @GetMapping("")
    public ResponseEntity<Image> getById(@RequestParam("name") String name) {
        return ResponseEntity.ok(imageRepository.getByName(name));
    }

    @GetMapping
    public ResponseEntity<List<Image>> getAll() {
        return ResponseEntity.ok(imageService.getAll());
    }
}
