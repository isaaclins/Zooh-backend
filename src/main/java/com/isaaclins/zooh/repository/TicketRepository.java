package com.isaaclins.zooh.repository;

import com.isaaclins.zooh.entity.UserEntity; // Import UserEntity
import org.springframework.data.jpa.repository.JpaRepository;
import com.isaaclins.zooh.entity.TicketEntity;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
    Optional<TicketEntity> findByUUID(String uuid);

    // Corrected method name to match the property name in TicketEntity
    void deleteByUserId(UserEntity userId); // Updated method signature

    // Add any other custom query methods you may need
}
