package com.isaaclins.zooh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "ticket", schema = "zooh")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticketid")
    private int ID;

    @Column(name = "used")
    private boolean Used;

    @Column(name = "cost", nullable = false)
    private double Cost;

    @Temporal(TemporalType.DATE)
    @Column(name = "expirationdate", nullable = false)
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private UserEntity user;

    public Ticket() {
    }

    public Ticket(int ID, boolean used, double cost, Date expirationDate, UserEntity user) {
        this.ID = ID;
        Used = used;
        Cost = cost;
        this.expirationDate = expirationDate;
        this.user = user;
    }
}
