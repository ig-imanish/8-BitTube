package com.eight.bittube.service;

import java.util.List;

import com.eight.bittube.dto.UserDTO;
import com.eight.bittube.model.Role;

public interface MainService {
    UserDTO getUserByUsername(String username);
    List<UserDTO> getAllUsersByRole(Role role);
    boolean deleteUserByUsernamePassword(String username, String password);
}
