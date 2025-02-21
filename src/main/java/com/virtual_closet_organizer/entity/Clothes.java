package com.virtual_closet_organizer.entity;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "clothes")
@Builder
public class Clothes {
    @Id
    private String id;


    private Users user;

    private String category;
    private String[] tags;
    private String imageUrl;
    private String color;

}