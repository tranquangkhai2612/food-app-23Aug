package com.khaitran.foodapp.controller;

import com.khaitran.foodapp.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getAllUsers(){

        return new ResponseEntity<>(userServiceImp.getAllUsers(), HttpStatus.OK);
    }
}
