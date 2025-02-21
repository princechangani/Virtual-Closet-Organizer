package com.virtual_closet_organizer.controller;


import com.virtual_closet_organizer.dto.UsersDto;
import com.virtual_closet_organizer.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody UsersDto usersDto) {
        userService.createUser(usersDto);

        return ResponseEntity.ok("User saved successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UsersDto usersDto) {
        String token = userService.login(usersDto);

        return ResponseEntity.ok(token);
    }


    @GetMapping("/get/{username}")
    public ResponseEntity<UsersDto> getUser(@PathVariable String username) {
        UsersDto user = userService.getUser(username);

        return ResponseEntity.ok(user);
    }


}
