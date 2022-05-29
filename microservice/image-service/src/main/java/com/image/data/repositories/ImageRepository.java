package com.image.data.repositories;

import com.image.data.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageRepository extends JpaRepository<Image, Long> {

    @Query(value = "select i from image i where i.name=?1")
    Image getByName(String name);
}
