package com.isaaclins.zooh.repository;

import com.isaaclins.zooh.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
    Optional<TicketEntity> findByUUID(String uuid);
}
