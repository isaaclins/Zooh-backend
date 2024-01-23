package com.isaaclins.zooh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="ticket")
public class Ticket{


    @Id
    @NonNull
    @GeneratedValue
    private int ID;
    private String OwnerName;
    private Boolean Used;
    private int Cost;
    private Date expiratonDate;

}
