package com.virtual_closet_organizer.service;

import com.virtual_closet_organizer.entity.Users;
import com.virtual_closet_organizer.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {


  final private UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findUsersByUsername(username);
        if (username != null) {
            return User.builder()
                    .username(users.getUsername())
                    .password(users.getPassword())
                    .roles("USER")
                    .build();
        }




        throw new UsernameNotFoundException("User not found with email: " + username);
    }
}
