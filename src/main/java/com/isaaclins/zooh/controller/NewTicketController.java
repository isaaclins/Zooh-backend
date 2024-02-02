package com.isaaclins.zooh.controller;

import com.isaaclins.zooh.entity.TicketEntity;
import com.isaaclins.zooh.entity.UserEntity;
import com.isaaclins.zooh.repository.TicketRepository;
import com.isaaclins.zooh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/ticket")
public class NewTicketController {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    @Autowired
    public NewTicketController(TicketRepository ticketRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

      // Create operation
      @PostMapping("/create")
      public ResponseEntity<TicketEntity> createTicket(@RequestBody TicketEntity ticket) {
          if (ticket.getExpirationDate() == null) {
              Calendar calendar = Calendar.getInstance();
              calendar.setTime(new Date());
              calendar.add(Calendar.YEAR, 1);
              Date expirationDate = calendar.getTime();
              ticket.setExpirationDate(expirationDate);
          }

          UserEntity user = ticket.getUserId();
          if (user != null) {
              UserEntity existingUser = userRepository.findById(user.getUserID()).orElse(null);

              if (existingUser != null) {
                  ticket.setUserId(existingUser);

                  // Generate random UUID and set it in the ticket
                  String randomUUID = UUID.randomUUID().toString().replace("-", "").substring(0, 24);
                  ticket.setUUID(randomUUID);

                  TicketEntity createdTicket = ticketRepository.save(ticket);
                  return ResponseEntity.ok(createdTicket);
              } else {
                  // Handle the case where the user with the given ID is not found
                  return ResponseEntity.badRequest().build();
              }
          } else {
              // Handle the case where the UserEntity in the ticket is null
              return ResponseEntity.badRequest().build();
          }
      }






    @PutMapping("/use/{UUID}")
    public ResponseEntity<TicketEntity> useTicket(@PathVariable String UUID) {
        Optional<TicketEntity> existingTicketOptional = ticketRepository.findByUUID(UUID);

        if (existingTicketOptional.isPresent()) {
            TicketEntity existingTicket = existingTicketOptional.get();
            existingTicket.setUsed(true);
            TicketEntity updated = ticketRepository.save(existingTicket);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Read operation
    @GetMapping("/get/{id}")
    public ResponseEntity<TicketEntity> getTicketById(@PathVariable int id) {
        Optional<TicketEntity> ticketOptional = ticketRepository.findById(id);
        return ticketOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Update operation
    @PutMapping("/update/{id}")
    public ResponseEntity<TicketEntity> updateTicket(@PathVariable int id, @RequestBody TicketEntity updatedTicket) {
        Optional<TicketEntity> existingTicketOptional = ticketRepository.findById(id);

        if (existingTicketOptional.isPresent()) {
            TicketEntity existingTicket = existingTicketOptional.get();
            existingTicket.setUsed(updatedTicket.isUsed());
            existingTicket.setCost(updatedTicket.getCost());
            existingTicket.setExpirationDate(updatedTicket.getExpirationDate());
            existingTicket.setUserId(updatedTicket.getUserId());

            TicketEntity updated = ticketRepository.save(existingTicket);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete operation
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable int id) {
        Optional<TicketEntity> ticketOptional = ticketRepository.findById(id);
        if (ticketOptional.isPresent()) {
            ticketRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // List all tickets
    @GetMapping("/all")
    public ResponseEntity<List<TicketEntity>> getAllTickets() {
        List<TicketEntity> tickets = ticketRepository.findAll();
        return ResponseEntity.ok(tickets);
    }
}
