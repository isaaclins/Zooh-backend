package com.isaaclins.zooh.controller;

import com.isaaclins.zooh.entity.AnimalEntity;
import com.isaaclins.zooh.entity.AnimalEntity;
import com.isaaclins.zooh.entity.AnimalEntity;
import com.isaaclins.zooh.repository.AnimalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @PostMapping("/create")
    public AnimalEntity createAnimal(@RequestBody AnimalEntity animal) {
        return animalRepository.save(animal);
    }

    @PutMapping("/update/{id}")
    public AnimalEntity updateAnimal(@PathVariable int id, @RequestBody AnimalEntity updatedAnimal) {
        AnimalEntity existingAnimal = animalRepository.findById(id).orElse(null);
        if (existingAnimal != null) {
            existingAnimal.setAge(updatedAnimal.getAge());
            existingAnimal.setName(updatedAnimal.getName());
            existingAnimal.setSpecie(updatedAnimal.getSpecie());
            existingAnimal.setLocationId(updatedAnimal.getLocationId());
            return animalRepository.save(existingAnimal);
        }
        return null;
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<AnimalEntity> getAnimalById(@PathVariable int id) {
        Optional<AnimalEntity> animalOptional = animalRepository.findById(id);
        return animalOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
}
