package com.isaaclins.zooh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private Boolean Used;
    private int Cost;

    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private UserEntity user;

}
