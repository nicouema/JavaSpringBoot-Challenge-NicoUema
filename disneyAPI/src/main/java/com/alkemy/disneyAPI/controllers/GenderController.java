package com.alkemy.disneyAPI.controllers;

import com.alkemy.disneyAPI.classes.Gender;
import com.alkemy.disneyAPI.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/gender")
public class GenderController {

    @Autowired
    public GenderService genderService;

    @GetMapping
    public ArrayList<Gender> getAllGender() {
        return genderService.getAllGender();
    }

}
