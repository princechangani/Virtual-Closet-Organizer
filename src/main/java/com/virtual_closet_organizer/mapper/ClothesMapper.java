package com.virtual_closet_organizer.mapper;


import com.virtual_closet_organizer.dto.ClothesDto;
import com.virtual_closet_organizer.dto.UsersDto;
import com.virtual_closet_organizer.entity.Clothes;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
public class ClothesMapper {

    private final UserMapper userMapper;

    public ClothesMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    ClothesDto toDto(Clothes clothes) {
        return ClothesDto.builder()
                .id(clothes.getId())
              .user(userMapper.toDto(clothes.getUser()))
                .id(clothes.getId())
                .color(clothes.getColor())
                .category(clothes.getCategory())
                .imageUrl(clothes.getImageUrl())
                .tags(clothes.getTags())
                .build();
}

  public Clothes toEntity(ClothesDto clothesDto) {
        return Clothes.builder()
                .id(new ObjectId().toString())
                .user(userMapper.toEntity(clothesDto.getUser()))
                .id(clothesDto.getId())
                .color(clothesDto.getColor())
                .category(clothesDto.getCategory())
                .imageUrl(clothesDto.getImageUrl())
                .tags(clothesDto.getTags())
                .build();
    }
}