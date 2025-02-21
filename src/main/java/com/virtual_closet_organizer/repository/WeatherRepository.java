package com.virtual_closet_organizer.repository;

import com.virtual_closet_organizer.model.Weather;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeatherRepository extends MongoRepository<Weather, String> {
}
