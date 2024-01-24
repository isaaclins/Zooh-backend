package com.isaaclins.zooh.repository;

import com.isaaclins.zooh.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
