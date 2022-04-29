package com.alkemy.disneyAPI.web.controllers;

import com.alkemy.disneyAPI.classes.Gender;
import com.alkemy.disneyAPI.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/genders")
public class GenderController {

    @Autowired
    public GenderService genderService;

    //  GET METHODS
    @GetMapping
    public ArrayList<Gender> getAllGender() {
        return genderService.getAllGender();
    }

    //  DELETE METHODS
    @DeleteMapping(value = "{id}")
    public String delGender(@PathVariable Integer id) {
        return genderService.delGender(id);
    }
    @DeleteMapping("/all")
    public void delAllGender(){
        genderService.delAllGender();
    }

    //  POST METHODS
    @PostMapping()
    public void saveGender(@RequestBody Gender gender) {
        genderService.saveGender(gender);
    }
}
