/*package com.isaaclins.zooh.controller;

import com.isaaclins.zooh.db.generalisation;

import com.isaaclins.zooh.entity.userentity;
import com.isaaclins.zooh.repository.ticketrepository;
import org.springframework.beans.factory.annotation.autowired;
import org.springframework.data.jpa.repository.support.simplejparepository;
import org.springframework.http.httpstatus;
import org.springframework.http.responseentity;
import org.springframework.web.bind.annotation.*;

import java.text.parseexception;
import java.text.simpledateformat;
import java.util.date;
import java.util.list;
import java.util.optional;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
    // CREATE (POST)
    @PostMapping("/create")
    public ResponseEntity<Ticket> createTicket(
            @RequestParam int ID,
            @RequestParam boolean used,
            @RequestParam double cost,
            @RequestParam String expirationDate,
            @RequestParam int userID) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate;

        try {
            parsedDate = dateFormat.parse(expirationDate);

            // Create a new TicketEntity
            Ticket newTicket = new Ticket();
            newTicket.setID(ID);
            newTicket.setUsed(used);
            newTicket.setCost(cost);
            newTicket.setExpirationDate(parsedDate);
            newTicket.setUserID(userID);

            if (Generalisation.register(newTicket)) {
                // Ticket creation successful
                return new ResponseEntity<>(newTicket, HttpStatus.CREATED);
            } else {
                // Ticket creation failed
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (ParseException e) {
            // Handle invalid date format
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
*/