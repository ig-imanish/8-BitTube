package com.eight.bittube.controller.user;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eight.bittube.dto.UserDTO;
import com.eight.bittube.model.Role;
import com.eight.bittube.payloads.AuthenticationResponse;
import com.eight.bittube.payloads.LoginRequest;
import com.eight.bittube.payloads.RegisterRequest;
import com.eight.bittube.service.auth.AuthenticationService;
import com.eight.bittube.service.user.UserService;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authService;
    private final UserService userService;

    public AuthenticationController(AuthenticationService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
            ) {
        return ResponseEntity.ok(authService.register(request, Role.USER));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody LoginRequest request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @GetMapping("/me")
    public UserDTO me(Principal principal) {
        String username = principal != null ? principal.getName() : null;
        UserDTO userDTO = userService.getUserByUsername(username);
        return userDTO;
    }
}
