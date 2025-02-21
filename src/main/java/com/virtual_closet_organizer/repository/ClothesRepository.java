package com.virtual_closet_organizer.repository;

import com.virtual_closet_organizer.entity.Clothes;
import com.virtual_closet_organizer.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ClothesRepository extends MongoRepository<Clothes, String> {

    List<Clothes> findClothesByUser(Users user);
}
