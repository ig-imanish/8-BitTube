package com.eight.bittube.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eight.bittube.dto.UserDTO;
import com.eight.bittube.dto.service.UserDTOService;
import com.eight.bittube.model.Role;
import com.eight.bittube.model.Token;
import com.eight.bittube.model.User;
import com.eight.bittube.repository.TokenRepository;
import com.eight.bittube.repository.UserRepository;
import com.eight.bittube.service.MainService;

@Service
public class UserService implements MainService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDTOService userDTOService;

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public UserDTO getUserByUsername(String username) {
        Optional<User> opUser = userRepository.findByUsername(username);
        if (opUser.isEmpty())
            return null;

        return userDTOService.convertUserToUserDTO(opUser.get());
    }

    @Override
    public List<UserDTO> getAllUsersByRole(Role role) {
        List<User> opUser = userRepository.findByRole(role);
        return userDTOService.convertListUserToUserDTO(opUser);
    }

    @Override
    @Transactional
    public boolean deleteUserByUsernamePassword(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty())
            return false;

        User user = optionalUser.get();
        boolean isOk = passwordEncoder.matches(password, user.getPassword());
        if (!isOk)
            return false;

        // Fetch and delete valid tokens first
        List<Token> validTokens = tokenRepository.findAllTokensByUser(user.getId());
        validTokens.forEach(tokenRepository::delete);

        // Now delete the user
        userRepository.deleteById(user.getId());

        System.out.println(user);
        return true;
    }

}
