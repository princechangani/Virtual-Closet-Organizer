package com.virtual_closet_organizer.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;




@Data
@Document("weather")
public class Weather {
  


    @Id
    private String id;
    private long queryCost;

    private double latitude;

    private double longitude;

    private String resolvedAddress;

    private String address;

    private String timezone;

    private double tzoffset;

    private List<Day> days;

    private List<Object> alerts;

    private CurrentConditions currentConditions;
}
