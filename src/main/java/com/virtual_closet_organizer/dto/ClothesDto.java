package com.virtual_closet_organizer.dto;

import com.virtual_closet_organizer.entity.Users;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;



@Data
@Builder
public class ClothesDto {


    private String id;


    private UsersDto user;

    private String category;
    private String[] tags;
    private String imageUrl;
    private String color;
}
