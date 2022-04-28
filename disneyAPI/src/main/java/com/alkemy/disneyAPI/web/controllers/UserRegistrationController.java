package com.alkemy.disneyAPI.web.controllers;

import com.alkemy.disneyAPI.services.UserService;
import com.alkemy.disneyAPI.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/auth/registration", method = {RequestMethod.POST, RequestMethod.GET})
public class UserRegistrationController {

    @Autowired
    private UserService userService;

//    @GetMapping
//    public String showRegistrationForm(){
//        return "registration";
//    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @PostMapping
    public String registerUser(@ModelAttribute("user")UserRegistrationDto userRegistrationDto){
        userService.save(userRegistrationDto);
        return "redirect:/auth/registration?success";
    }

}
