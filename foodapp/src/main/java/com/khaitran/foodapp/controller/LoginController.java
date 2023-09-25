package com.khaitran.foodapp.controller;


import com.khaitran.foodapp.payload.ResponseData;
import com.khaitran.foodapp.payload.request.SignUpRequest;
import com.khaitran.foodapp.service.LoginService;
import com.khaitran.foodapp.service.imp.LoginServiceImp;
import com.khaitran.foodapp.util.JwtUtilHelper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.Base64;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginServiceImp loginServiceImp;

    @Autowired
    JwtUtilHelper jwtUtilHelper;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username, @RequestParam String password) {
        ResponseData responseData = new ResponseData();

        if (loginServiceImp.checkLogin(username, password)) {
            String token = jwtUtilHelper.generateToken(username);
            responseData.setData(token);
        } else {
            responseData.setData("");
            responseData.setIsSuccess(false);
        }

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest) {
        ResponseData responseData = new ResponseData();
        responseData.setData(loginServiceImp.addUser(signUpRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
