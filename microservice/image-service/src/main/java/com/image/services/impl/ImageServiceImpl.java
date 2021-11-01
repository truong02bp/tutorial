package com.image.services.impl;

import com.image.data.entities.Image;
import com.image.data.repositories.ImageRepository;
import com.image.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public Image getById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Image> getAll() {
        return imageRepository.findAll();
    }
}
