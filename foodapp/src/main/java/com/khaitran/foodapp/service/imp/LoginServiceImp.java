package com.khaitran.foodapp.service.imp;

import com.khaitran.foodapp.dto.UserDTO;
import com.khaitran.foodapp.payload.request.SignUpRequest;

import java.util.List;

public interface LoginServiceImp {
    List<UserDTO> getAllUsers();
    boolean checkLogin(String username, String password);
    boolean addUser(SignUpRequest signUpRequest);
}
