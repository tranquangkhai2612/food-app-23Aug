package com.khaitran.foodapp.service;

import com.khaitran.foodapp.dto.UserDTO;
import com.khaitran.foodapp.entity.Users;
import com.khaitran.foodapp.repository.UserRepository;
import com.khaitran.foodapp.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceImp {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
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
}
