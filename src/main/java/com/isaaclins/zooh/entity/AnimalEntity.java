package com.isaaclins.zooh.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "animal", schema = "zooh")
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animalID")
    private int animalId;

    @Column(name = "specie", nullable = false)
    private String specie;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "locationID", nullable = false)
    private int locationId;

    public AnimalEntity() {
    }

    public AnimalEntity(String specie, String name, int age, int locationId) {
        this.specie = specie;
        this.name = name;
        this.age = age;
        this.locationId = locationId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
}
