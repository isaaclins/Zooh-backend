package com.isaaclins.zooh.repository;

import com.isaaclins.zooh.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository <Ticket, Integer>{
}