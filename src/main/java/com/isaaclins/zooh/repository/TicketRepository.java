package com.isaaclins.zooh.repository;

import com.isaaclins.zooh.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository <TicketEntity, Integer>{
}