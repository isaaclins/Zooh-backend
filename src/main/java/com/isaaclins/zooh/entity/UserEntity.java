package com.isaaclins.zooh.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "user", schema = "zooh")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int userID;

    @NonNull
    @Column(name = "username", nullable = false)
    private String username;

    @NonNull
    @Column(name = "password", nullable = false)
    private String password;

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity(int userID, @NonNull String username, @NonNull String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    public UserEntity() {
    }

}
