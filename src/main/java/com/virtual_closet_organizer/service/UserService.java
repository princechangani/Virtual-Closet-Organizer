package com.virtual_closet_organizer.service;

import com.virtual_closet_organizer.dto.UsersDto;
import com.virtual_closet_organizer.entity.Users;
import com.virtual_closet_organizer.mapper.UserMapper;
import com.virtual_closet_organizer.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
     final private UserRepository userRepository;
     final private UserMapper userMapper;
     private final JWTService jwtService ;
    private final AuthenticationManager authManager;
    private final PasswordEncoder encoder;



    public UserService(UserRepository userRepository, UserMapper userMapper, JWTService jwtService, AuthenticationManager authManager, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.jwtService = jwtService;
        this.authManager = authManager;
        this.encoder = encoder;
    }



   public void createUser(UsersDto usersDto) {


        usersDto.setPassword(encoder.encode(usersDto.getPassword()));
        Users users = userMapper.toEntity(usersDto);
        userRepository.save(users);

    }

    public String login(UsersDto usersDto) {

        Users user = userRepository.findUsersByUsername(usersDto.getUsername());

        if(user == null) {
            throw new RuntimeException("User not found");
        }
       /* try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            if(authentication.isAuthenticated()) {

            }


        }

        catch (Exception e) {
            throw new RuntimeException("User not found");
        }
*/

        return  jwtService.generateToken(user.getUsername());

    }


    public UsersDto getUser(String username) {

        Users user = userRepository.findUsersByUsername(username);
        if(user == null) {
            throw new RuntimeException("User not found");
    }
        return userMapper.toDto(user);
    }
}
