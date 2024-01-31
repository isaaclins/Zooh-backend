package com.isaaclins.zooh.controller;

import com.isaaclins.zooh.entity.TicketEntity;
import com.isaaclins.zooh.entity.UserEntity;
import com.isaaclins.zooh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @GetMapping("/get/{id}")
    public UserEntity getUser(@PathVariable int id) {
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/update/{id}")
    public UserEntity updateUser(@PathVariable int id, @RequestBody UserEntity updatedUser) {
        UserEntity existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            return userRepository.save(existingUser);
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return "User deleted successfully";
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = (List<UserEntity>) userRepository.findAll();
        return ResponseEntity.ok(users);
    }
}
