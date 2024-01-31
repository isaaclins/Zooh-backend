package com.isaaclins.zooh.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tag", schema = "zooh")
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tagID")
    private int tagID;

    @Column(name = "tagname", nullable = false)
    private String tagName;

    public TagEntity() {
    }

    public TagEntity(int tagID, String tagName) {
        this.tagID = tagID;
        this.tagName = tagName;
    }

    public void setTagID(int tagID) {
        this.tagID = tagID;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getTagID() {
        return tagID;
    }

    public String getTagName() {
        return tagName;
    }
}
