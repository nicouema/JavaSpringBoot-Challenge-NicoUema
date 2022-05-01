package com.alkemy.disneyAPI.services;

import com.alkemy.disneyAPI.classes.Gender;
import com.alkemy.disneyAPI.repositories.GendersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GenderService {

    @Autowired
    private GendersRepository genderRepository;

    /**
     *
     * @param genderId: Gender's id searched.
     * @return true if it's exist, otherwise false.
     */
    public boolean genderExist(Integer genderId){
        return genderRepository.existsById(genderId);
    }


    public ArrayList<Gender> getAllGender() {
        return (ArrayList<Gender>) genderRepository.findAll();
    }
    public Gender getGenderByID(Integer genderId) {
        if (genderExist(genderId)) {
            return genderRepository.findById(genderId).get();
        }
        else {
            return null;
        }
    }

    public Gender createGender(Gender gender) {
        return genderRepository.save(gender);
    }

    public String delGender(Integer id){
        if (genderExist(id)) {
            genderRepository.deleteById(id);
            return "Gender with id: " + id + " removed";
        }
        else {
            return "Gender not found!";
        }
    }
    public void delAllGender(){
        genderRepository.deleteAll();
    }

}
