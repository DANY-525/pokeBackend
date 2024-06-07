package com.example.pokemonapp.service;

import com.example.pokemonapp.dto.UserDto;
import com.example.pokemonapp.entities.User;
import com.example.pokemonapp.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }
    public  boolean ValidateEmail(String emailAdress){
        String regexPatternEmail =  "^(.+)@(\\S+)$";
        return   Pattern.compile(regexPatternEmail)
                .matcher(emailAdress)
                .matches();
    }
    public  boolean validatePassword(String password){
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#?\\]]).{10,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public boolean validateEmailExist(String email){
    List<User>  us =   registrationRepository.findByEmail(email);
       // System.out.println(us.size());
        if(us.size()>0) {
            return false;
        } else {
            return true;
        }
    }

    public User addUser(UserDto userDto){
        return this.registrationRepository.save(User.builder().name(userDto.getName()).phonenumber(userDto.getPhonenumber()).email(userDto.getEmail()).password(userDto.getPassword()).build());
    }
    public Iterable<User> getUsers(){
        return  this.registrationRepository.findAll();
    }













}
