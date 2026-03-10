package com.workshop.model.repository;

import com.workshop.model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImageRepository extends JpaRepository<Image, Long> {


}
