package com.isaaclins.zooh.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "event", schema = "zooh")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventID")
    private int eventID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "tagIDFS", nullable = false)
    private int tagIDFS;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time")
    private Date time;

    @ManyToOne
    @JoinColumn(name = "tagIDFS", nullable = false, insertable = false, updatable = false)
    @JsonProperty("Tag")
    private TagEntity tag;

    public EventEntity() {
    }

    public EventEntity(int eventID, String name, int tagIDFS, Date time, TagEntity tag) {
        this.eventID = eventID;
        this.name = name;
        this.tagIDFS = tagIDFS;
        this.time = time;
        this.tag = tag;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTagIDFS(int tagIDFS) {
        this.tagIDFS = tagIDFS;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setTag(TagEntity tag) {
        this.tag = tag;
    }

    public int getEventID() {
        return eventID;
    }

    public String getName() {
        return name;
    }

    public int getTagIDFS() {
        return tagIDFS;
    }

    public Date getTime() {
        return time;
    }

    public TagEntity getTag() {
        return tag;
    }
}


