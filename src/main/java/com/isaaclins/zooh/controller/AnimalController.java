package com.isaaclins.zooh.controller;

import com.isaaclins.zooh.entity.AnimalEntity;
import com.isaaclins.zooh.repository.AnimalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AnimalEntity>> getAllAnimals() {
        List<AnimalEntity> animals = animalRepository.findAll();
        return ResponseEntity.ok(animals);
    }
}
