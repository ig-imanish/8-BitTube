package com.eight.bittube.dto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eight.bittube.dto.UserDTO;
import com.eight.bittube.model.User;

@Service
public class UserDTOService {

    public UserDTO convertUserToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUsername(user.getUsername());
        userDTO.setRole(user.getRole());

        return userDTO;
    }

    public List<UserDTO> convertListUserToUserDTO(List<User> users) {
    List<UserDTO> userDTOs = new ArrayList<>(); 

    for (User usr : users) {
        userDTOs.add(convertUserToUserDTO(usr));
    }


    // return users.stream()
    //             .map(this::convertUserToUserDTO) 
    //             .collect(Collectors.toList());  

    return userDTOs;
}

}
