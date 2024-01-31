package com.isaaclins.zooh.controller;

import com.isaaclins.zooh.entity.EventEntity;
import com.isaaclins.zooh.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @PostMapping("/create")
    public EventEntity createEvent(@RequestBody EventEntity event) {
        return eventRepository.save(event);
    }

    @GetMapping("/get/{id}")
    public EventEntity getEvent(@PathVariable int id) {
        return eventRepository.findById(id).orElse(null);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<EventEntity> updateEvent(@PathVariable int id, @RequestBody EventEntity updatedEvent) {
        EventEntity existingEvent = eventRepository.findById(id).orElse(null);

        if (existingEvent != null) {
            // Update only non-null properties of the existing event
            if (updatedEvent.getName() != null) {
                existingEvent.setName(updatedEvent.getName());
            }

            if (updatedEvent.getTagIDFS() != 0) {
                existingEvent.setTagIDFS(updatedEvent.getTagIDFS());
            }

            if (updatedEvent.getTime() != null) {
                existingEvent.setTime(updatedEvent.getTime());
            }

            return ResponseEntity.ok(eventRepository.save(existingEvent));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEvent(@PathVariable int id) {
        eventRepository.deleteById(id);
        return "Event deleted successfully";
    }

    @GetMapping("/all")
    public ResponseEntity<List<EventEntity>> getAllEvents() {
        List<EventEntity> events = (List<EventEntity>) eventRepository.findAll();
        return ResponseEntity.ok(events);
    }
}
