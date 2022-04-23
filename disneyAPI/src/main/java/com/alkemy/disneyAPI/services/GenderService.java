package com.alkemy.disneyAPI.services;

import com.alkemy.disneyAPI.classes.Gender;
import com.alkemy.disneyAPI.repositories.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GenderService {

    @Autowired
    private GenderRepository genderRerpository;

    public ArrayList<Gender> getAllGender() {
        return (ArrayList<Gender>) genderRerpository.findAll();
    }

    public Gender saveGender(Gender gender) {
        return genderRerpository.save(gender);
    }
}
