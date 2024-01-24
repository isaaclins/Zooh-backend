package com.isaaclins.zooh.repository;

import com.isaaclins.zooh.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserEntity, Integer>{
}
