package com.isaaclins.zooh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.ByteBuffer;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private boolean Used;
    private double Cost;

    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private UserEntity user;

    public Ticket(){
    }

    public Ticket(int ID, boolean used, double cost, Date expirationDate, UserEntity user){
        this.ID = ID;
        Used = used;
        Cost = cost;
        this.expirationDate = expirationDate;
        this.user = user;
    }



}
