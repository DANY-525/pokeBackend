package com.example.pokemonapp.controller;

import com.example.pokemonapp.service.RegistrationService;
import com.example.pokemonapp.dto.UserDto;
import com.example.pokemonapp.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registrationUser")
public class RegistrationController {
     @Autowired
    RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<String> RegisterUser(@RequestBody UserDto userDto){
        try {
         //   UserDto us =  UserDto.builder().email(userDto.getEmail()).name(userDto.getName()).password(userDto.getPassword()).phoneNumber(userDto.getPhoneNumber()).build();
            boolean validatePassword =registrationService.validatePassword(userDto.getPassword());
            boolean validateEmail = registrationService.ValidateEmail(userDto.getEmail());
            boolean validateAlreadyExistOnDatabase = registrationService.validateEmailExist(userDto.getEmail());
            if(!validateEmail){
                return new ResponseEntity<>("WrongEmail",HttpStatus.NOT_ACCEPTABLE);
            }else if (!validatePassword){
                return new ResponseEntity<>("Wrong password",HttpStatus.NOT_ACCEPTABLE);
            } else if (!validateAlreadyExistOnDatabase) {
                return new ResponseEntity<>("Email already exist on Database",HttpStatus.NOT_ACCEPTABLE);
            } else {
                User us = registrationService.addUser(userDto);
                return new ResponseEntity<>(userDto.toString(),HttpStatus.OK);
            }
        }catch (Exception e){
            return  new ResponseEntity<>(userDto.toString(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> getAll(){
        return  new ResponseEntity<Iterable<User>>(registrationService.getUsers(),HttpStatus.OK);
    }

}
