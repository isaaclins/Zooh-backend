package com.isaaclins.zooh.controller;

import com.isaaclins.zooh.entity.TicketEntity;
import com.isaaclins.zooh.entity.UserEntity;
import com.isaaclins.zooh.repository.TicketRepository;
import com.isaaclins.zooh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

// ... (other imports)

// ... (other imports)

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    @Autowired
    public TicketController(TicketRepository ticketRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    // Create operation
    @PostMapping("/create")
    public ResponseEntity<List<TicketEntity>> createTickets(@RequestBody Map<String, Object> ticketRequest) {
        int kidsCount = (int) ticketRequest.get("kidsCount");
        int adultsCount = (int) ticketRequest.get("adultsCount");
        int elderlyCount = (int) ticketRequest.get("elderlyCount");
        int userId = (int) ticketRequest.get("userId");

        // Retrieve the UserEntity using the userId
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            List<TicketEntity> tickets = new ArrayList<>();

            // Create individual tickets for each type
            for (int i = 0; i < kidsCount; i++) {
                TicketEntity ticket = createTicketEntity(user, 10.0);
                tickets.add(ticket);
            }

            for (int i = 0; i < adultsCount; i++) {
                TicketEntity ticket = createTicketEntity(user, 20.0);
                tickets.add(ticket);
            }

            for (int i = 0; i < elderlyCount; i++) {
                TicketEntity ticket = createTicketEntity(user, 15.0);
                tickets.add(ticket);
            }

            // Save all tickets to the database
            List<TicketEntity> createdTickets = ticketRepository.saveAll(tickets);
            return ResponseEntity.ok(createdTickets);
        } else {
            // Handle the case where the user with the given ID is not found
            return ResponseEntity.badRequest().build();
        }
    }

    private TicketEntity createTicketEntity(UserEntity user, double cost) {
        TicketEntity ticket = new TicketEntity();
        ticket.setUsed(false);
        ticket.setCost(cost);
        ticket.setExpirationDate(calculateExpirationDate());
        ticket.setUUID(generateRandomUUID());
        ticket.setUserId(user);
        return ticket;
    }

    // Helper method to calculate expiration date (30 days from today)
    private Date calculateExpirationDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        return calendar.getTime();
    }

    // Helper method to generate a random UUID
    private String generateRandomUUID() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 24);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TicketEntity>> getAllTickets() {
        List<TicketEntity> tickets = ticketRepository.findAll();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
}
