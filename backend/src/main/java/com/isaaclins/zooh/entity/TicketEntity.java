package com.isaaclins.zooh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
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
}
