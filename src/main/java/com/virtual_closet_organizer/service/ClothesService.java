package com.virtual_closet_organizer.service;


import com.virtual_closet_organizer.dto.ClothesDto;
import com.virtual_closet_organizer.dto.UsersDto;
import com.virtual_closet_organizer.entity.Clothes;
import com.virtual_closet_organizer.entity.Users;
import com.virtual_closet_organizer.mapper.ClothesMapper;
import com.virtual_closet_organizer.mapper.UserMapper;
import com.virtual_closet_organizer.repository.ClothesRepository;

import com.virtual_closet_organizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class ClothesService {




    @Value("${weather.api.url}")
    String apiUrl ;

    @Value("${WEATHER_API_KEY}")
    String apiKey;

    private final ClothesRepository clothesRepository;
    private final UserRepository userRepository;
    private final ClothesMapper clothesMapper;
    private final UserMapper userMapper;


    public ClothesService(ClothesRepository clothesRepository, UserRepository userRepository, ClothesMapper clothesMapper, UserMapper userMapper) {
        this.clothesRepository = clothesRepository;
        this.userRepository = userRepository;
        this.clothesMapper = clothesMapper;
        this.userMapper = userMapper;
    }


     public void uploadClothes(ClothesDto clothesDto, String username) {

         Users users = userRepository.findUsersByUsername(username.trim());
         UsersDto usersDto = userMapper.toDto(users);
         clothesDto.setUser(usersDto);
         Clothes clothes = clothesMapper.toEntity(clothesDto);
        clothes.setUser(users);

        String url = apiUrl.replace("latitude","22.00000").replace("longitude","70.00000");

        System.out.println(url);

        clothesRepository.save(clothes);

    }
}
