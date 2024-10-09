package com.helloIftekhar.springJwt.controller.team;


    


import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helloIftekhar.springJwt.model.AuthenticationResponse;
import com.helloIftekhar.springJwt.model.Role;
import com.helloIftekhar.springJwt.payloads.LoginRequest;
import com.helloIftekhar.springJwt.payloads.RegisterRequest;
import com.helloIftekhar.springJwt.service.AuthenticationService;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    
    private final AuthenticationService authService;

    public TeamController(AuthenticationService authService) {
        this.authService = authService;
    }


    @PostMapping("/admin/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
            ) {
        return ResponseEntity.ok(authService.register(request, Role.ADMIN));
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
