package com.image.services;

import com.image.data.entities.Image;

import java.util.List;

public interface ImageService {

    Image getById(Long id);

    List<Image> getAll();

}
