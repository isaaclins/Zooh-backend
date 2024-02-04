package com.isaaclins.zooh.controller;

import java.util.Map;
import java.util.HashMap;
import com.isaaclins.zooh.entity.UserEntity;
import com.isaaclins.zooh.repository.UserRepository;
import com.isaaclins.zooh.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody UserEntity user) {
        Optional<UserEntity> existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with the same name already exists");
        }

        UserEntity savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable int id) {
        Optional<UserEntity> user = userRepository.findById(id);

        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserEntity> updateUser(
            @PathVariable int id,
            @RequestBody UpdateUserRequest updateUserRequest
    ) {
        Optional<UserEntity> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            UserEntity userToUpdate = existingUser.get();

            // Update the user data
            userToUpdate.setUsername(updateUserRequest.getUsername());
            userToUpdate.setPassword(updateUserRequest.getNewPassword());

            UserEntity savedUser = userRepository.save(userToUpdate);
            return ResponseEntity.ok(savedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        Optional<UserEntity> userOptional = userRepository.findById(id);

        if (userOptional.isPresent() && isUserDeletable(id)) {
            deleteAssociatedTickets(id);
            userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found or cannot delete user with associated records");
        }
    }

    private boolean isUserDeletable(int userId) {
        return true;
    }

    private void deleteAssociatedTickets(int userId) {
        // Implement logic to delete associated tickets
        // For example, if TicketEntity has a userId field, you can use ticketRepository.deleteByUserId(userId)
        // ticketRepository.deleteByUserId(userId);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = (List<UserEntity>) userRepository.findAll();
        System.out.println("Retrieved users: " + users);
        return ResponseEntity.ok(users);
    }


    @PutMapping("/addFavorite/{userId}/{eventId}")
    public ResponseEntity<UserEntity> addFavoriteEvent(@PathVariable int userId, @PathVariable int eventId) {
        Optional<UserEntity> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            List<Integer> favoriteEventIds = user.getFavoriteEventIds();

            if (favoriteEventIds.contains(eventId)) {
                // If eventId is already in the list, remove it
                favoriteEventIds.remove(Integer.valueOf(eventId));
            } else {
                // If eventId is not in the list, add it
                favoriteEventIds.add(eventId);
            }

            user.setFavoriteEventIds(favoriteEventIds);
            userRepository.save(user);

            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody UserEntity loginUser) {
        Optional<UserEntity> existingUser = userRepository.findByUsername(loginUser.getUsername());

        if (existingUser.isPresent()) {
            UserEntity user = existingUser.get();

            // Check if the provided password matches the stored password
            if (user.getPassword().equals(loginUser.getPassword())) {
                // Include the user ID and name in the response
                Map<String, Object> response = new HashMap<>();
                response.put("message", "Login successful");
                response.put("id", user.getUserID()); // Assuming getUserID() returns the ID
                response.put("name", user.getUsername());

                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }


}
