package com.virtual_closet_organizer.entity;


import com.mongodb.lang.Nullable;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@Builder
public class Users {
    @Id
    private String id;
    private String username;
    private String password;

}
