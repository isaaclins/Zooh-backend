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
    private int TicketId;

    @Column(name = "used")
    private boolean Used;

    @Column(name = "cost", nullable = false)
    private double Cost;

    @Temporal(TemporalType.DATE)
    @Column(name = "expirationdate")
    private Date ExpirationDate;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonProperty("UserId")
    private UserEntity UserId;


    public TicketEntity() {
    }

    public TicketEntity(int ticketId, boolean used, double cost, Date expirationDate, UserEntity userId) {
        TicketId = ticketId;
        Used = used;
        Cost = cost;
        ExpirationDate = expirationDate;
        UserId = userId;
    }

    public void setTicketId(int ticketId) {
        TicketId = ticketId;
    }

    public void setUsed(boolean used) {
        Used = used;
    }

    public void setCost(double cost) {
        Cost = cost;
    }

    public void setExpirationDate(Date expirationDate) {
        ExpirationDate = expirationDate;
    }

    public void setUserId(UserEntity userId) {
        UserId = userId;
    }

    public int getTicketId() {
        return TicketId;
    }

    public boolean isUsed() {
        return Used;
    }

    public double getCost() {
        return Cost;
    }

    public Date getExpirationDate() {
        return ExpirationDate;
    }

    public UserEntity getUserId() {
        return UserId;
    }

}
