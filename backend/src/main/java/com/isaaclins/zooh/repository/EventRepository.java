package com.isaaclins.zooh.repository;


import com.isaaclins.zooh.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Integer> {
}
