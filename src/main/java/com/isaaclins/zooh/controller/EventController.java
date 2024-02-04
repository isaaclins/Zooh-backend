package com.isaaclins.zooh.controller;

import com.isaaclins.zooh.entity.UserEntity;
import com.isaaclins.zooh.entity.EventEntity;
import com.isaaclins.zooh.repository.EventRepository;
import com.isaaclins.zooh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Autowired
    public EventController(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    public EventEntity createEvent(@RequestBody EventEntity event) {
        return eventRepository.save(event);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EventEntity> getEvent(@PathVariable int id) {
        EventEntity event = eventRepository.findById(id).orElse(null);
        return event != null ? ResponseEntity.ok(event) : ResponseEntity.notFound().build();
    }

    @PostMapping("/addFavorite/{userId}/{eventId}")
    public ResponseEntity<UserEntity> addFavoriteEvent(@PathVariable int userId, @PathVariable int eventId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        EventEntity event = eventRepository.findById(eventId).orElse(null);

        if (user != null && event != null) {
            // Check if the eventId is not already in the list to avoid duplicates
            if (!user.getFavoriteEventIds().contains(eventId)) {
                user.getFavoriteEventIds().add(eventId);
                userRepository.save(user);
                return ResponseEntity.ok(user);
            } else {
                // Handle case where the event is already in the favorites
                return ResponseEntity.badRequest().body(user);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<EventEntity>> getAllEvents() {
        List<EventEntity> allEvents = eventRepository.findAll();
        return ResponseEntity.ok(allEvents);
    }

    // Other methods...

    // You can similarly implement removeFavoriteEvent and other methods.
}
