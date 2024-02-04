package com.isaaclins.zooh.entity;

import jakarta.persistence.*;


import lombok.*;

import java.util.List;

@Entity
@Table(name = "users", schema = "zooh") // Updated table name to "users"
public class UserEntity {

    public int getId() {
        return userID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id") // Updated column name to "user_id"
    private int userID;

    @NonNull
    @Column(name = "username", nullable = false)
    private String username;

    @NonNull
    @Column(name = "password", nullable = false)
    private String password;

    @ElementCollection
    @CollectionTable(name = "user_favorite_events", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "event_id")
    private List<Integer> favoriteEventIds;

    // Constructors...

    // Getters and Setters...

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getFavoriteEventIds() {
        return favoriteEventIds;
    }

    public void setFavoriteEventIds(List<Integer> favoriteEventIds) {
        this.favoriteEventIds = favoriteEventIds;
    }

    public UserEntity(int userID, @NonNull String username, @NonNull String password, List<Integer> favoriteEventIds) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.favoriteEventIds = favoriteEventIds;
    }

    public UserEntity() {
    }
}
