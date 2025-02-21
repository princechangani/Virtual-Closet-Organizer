package com.virtual_closet_organizer.repository;

import com.virtual_closet_organizer.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface UserRepository extends MongoRepository<Users, String> {
    Users findUsersByUsername(String username);
}
