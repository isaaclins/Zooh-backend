package com.isaaclins.zooh.repository;

import com.isaaclins.zooh.entity.TagEntity;
import com.isaaclins.zooh.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity, Integer> {
}
