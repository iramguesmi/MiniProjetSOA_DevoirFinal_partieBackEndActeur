package com.iram.acteur.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iram.acteur.entitites.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}