package com.eight.bittube.controller.admin;


import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eight.bittube.model.AuthenticationResponse;
import com.eight.bittube.payloads.LoginRequest;
import com.eight.bittube.service.AuthenticationService;



@RestController
@RequestMapping("/api/admin")
public class AdminController {
    
    private final AuthenticationService authService;

    public AdminController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody LoginRequest request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @GetMapping("/me")
    public String me(Principal principal) {
        return principal != null ? principal.getName() : null;
    }
    
}
