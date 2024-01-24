package com.isaaclins.zooh.controller;

import com.isaaclins.zooh.entity.Ticket;
import com.isaaclins.zooh.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // CREATE (POST)
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // READ (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable int id) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        return optionalTicket
                .map(ticket -> new ResponseEntity<>(ticket, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // UPDATE (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable int id, @RequestBody Ticket updatedTicket) {
        if (ticketRepository.existsById(id)) {
            updatedTicket.setID(id);
            Ticket savedTicket = ticketRepository.save(updatedTicket);
            return new ResponseEntity<>(savedTicket, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable int id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
            return new ResponseEntity<>("Ticket with ID " + id + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Ticket with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
