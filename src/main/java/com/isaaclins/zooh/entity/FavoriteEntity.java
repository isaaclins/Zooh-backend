package com.isaaclins.zooh.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "favorite_events", schema = "zooh")
public class FavoriteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventEntity event;

    public FavoriteEntity() {
    }

    public FavoriteEntity(UserEntity user, EventEntity event) {
        this.user = user;
        this.event = event;
    }

    // Getter and setter for user and event

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public EventEntity getEvent() {
        return event;
    }

    public void setEvent(EventEntity event) {
        this.event = event;
    }
}
