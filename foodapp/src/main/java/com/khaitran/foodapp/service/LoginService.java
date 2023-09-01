package com.khaitran.foodapp.service;

import com.khaitran.foodapp.dto.UserDTO;
import com.khaitran.foodapp.entity.Roles;
import com.khaitran.foodapp.entity.Users;
import com.khaitran.foodapp.payload.request.SignUpRequest;
import com.khaitran.foodapp.repository.UserRepository;
import com.khaitran.foodapp.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements LoginServiceImp {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers(){

        List<Users> listUser = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for (Users users:listUser){
            UserDTO userDTO = new UserDTO();
            userDTO.setId(users.getId());
            userDTO.setFullname(users.getFullname());
            userDTO.setUserName((users.getUsername()));
            userDTO.setCreateDate(users.getCreatedDate());

            userDTOList.add(userDTO);
        }

        return userDTOList;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        List<Users> listUser = userRepository.findByUsernameAndPassword(username,password);

        return listUser.size() > 0;
    }

    @Override
    public boolean addUser(SignUpRequest signUpRequest) {
        Users user = new Users();
        Roles role = new Roles();

        role.setId(signUpRequest.getRoleId());

        user.setFullname(signUpRequest.getFullname());
        user.setUsername(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setRoles(role);
        try {
            userRepository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
