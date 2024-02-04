package com.isaaclins.zooh.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "ticket", schema = "zooh")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticketid")
    private int ticketId;

    @Column(name = "used")
    private boolean used;

    @Column(name = "cost", nullable = false)
    private double cost;

    @Temporal(TemporalType.DATE)
    @Column(name = "expirationdate")
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonProperty("UserId")
    private UserEntity userId;

    @Column(name = "UUID", nullable = false)
    private String UUID;

    // Constructors, getters, and setters...

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    // Other methods...

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
}
