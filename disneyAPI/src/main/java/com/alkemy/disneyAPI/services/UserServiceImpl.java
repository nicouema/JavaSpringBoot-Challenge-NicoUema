package com.alkemy.disneyAPI.services;

import com.alkemy.disneyAPI.classes.User;
import com.alkemy.disneyAPI.repositories.UsersRepository;
import com.alkemy.disneyAPI.securityweb.Role;
import com.alkemy.disneyAPI.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UsersRepository userRepository;
    
    public UserServiceImpl(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        Role role = new Role("USER");
        User user = new User(userRegistrationDto.getName(), userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(), userRegistrationDto.getPassword());
        return userRepository.save(user);
    }
}
