package com.isaaclins.zooh.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @NonNull
    @GeneratedValue
    private int userID;

    @NonNull
    private String username;

    @NonNull
    private String password;

    public int getUserID(){
        return userID;
    }

    @NonNull
    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public UserEntity setUserID(int userID){
        this.userID = userID;
        return this;
    }

    public UserEntity setUsername(@NonNull String username){
        this.username = username;
        return this;
    }

    public UserEntity setPassword(String password){
        this.password = password;
        return this;
    }
}