package com.eight.bittube.controller.admin;


import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eight.bittube.payloads.AuthenticationResponse;
import com.eight.bittube.payloads.LoginRequest;
import com.eight.bittube.service.auth.AuthenticationService;
import com.eight.bittube.service.user.UserService;



@RestController
@RequestMapping("/api/admin")
public class AdminController {
    
    private final AuthenticationService authService;

    private final UserService userService;

    public AdminController(AuthenticationService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody LoginRequest request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam String username, @RequestParam String password){
        if(userService.deleteUserByUsernamePassword(username, password)){
            return ResponseEntity.ok("Deleted");
        } else {
            return ResponseEntity.status(401).body("Not deleted");
        }
    }

    @GetMapping("/me")
    public String me(Principal principal) {
        return principal != null ? principal.getName() : null;
    }
    
}
