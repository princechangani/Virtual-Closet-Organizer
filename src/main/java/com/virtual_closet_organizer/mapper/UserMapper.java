package com.virtual_closet_organizer.mapper;

import com.virtual_closet_organizer.dto.UsersDto;
import com.virtual_closet_organizer.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {


    public UsersDto toDto(Users user) {

        return UsersDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();

    }

    public Users toEntity(UsersDto usersDto) {
        return Users.builder()
                .id( new ObjectId().toString())
                .username(usersDto.getUsername())
                .password(usersDto.getPassword())
                .build();
    }
}
