package com.isaaclins.zooh.controller;

public class UpdateUserRequest {
    private String currentPassword;
    private String username;
    private String newPassword;

    // Constructors, getters, and setters

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    // Constructors, getters, and setters
}
