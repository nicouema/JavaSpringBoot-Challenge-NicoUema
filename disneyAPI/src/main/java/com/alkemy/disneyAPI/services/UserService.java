package com.alkemy.disneyAPI.services;

import com.alkemy.disneyAPI.classes.User;
import com.alkemy.disneyAPI.web.dto.UserRegistrationDto;

public interface UserService {

    User save(UserRegistrationDto registrationDto);

}
