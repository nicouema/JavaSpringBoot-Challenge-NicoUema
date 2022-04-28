package com.alkemy.disneyAPI.web.controllers;

import com.alkemy.disneyAPI.classes.Gender;
import com.alkemy.disneyAPI.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/genders", method = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.GET})
public class GenderController {

    @Autowired
    public GenderService genderService;

    @GetMapping
    public ArrayList<Gender> getAllGender() {
        return genderService.getAllGender();
    }

    @DeleteMapping("/del={id}")
    public String delGender(@PathVariable Integer id) {
        return genderService.delGender(id);
    }

    @DeleteMapping("/del=all")
    public void delAllGender(){
        genderService.delAllGender();
    }

    @PostMapping("/save")
    public void saveGender(Gender gender) {
        genderService.saveGender(gender);
    }
}
