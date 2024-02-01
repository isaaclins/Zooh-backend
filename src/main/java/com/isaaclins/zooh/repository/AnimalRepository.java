package com.isaaclins.zooh.repository;

import com.isaaclins.zooh.entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Integer> {
}
