package com.eight.bittube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eight.bittube.model.Role;
import com.eight.bittube.payloads.RegisterRequest;
import com.eight.bittube.service.auth.AuthenticationService;

@SpringBootApplication
public class SpringJwtApplication implements CommandLineRunner {

	@Autowired
	private AuthenticationService authenticationService;

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		RegisterRequest registerRequest = new RegisterRequest();
		registerRequest.setFirstName("Manish");
		registerRequest.setLastName("Kumar");
		registerRequest.setUsername("Manish06");
		registerRequest.setPassword("Manish06");
		authenticationService.register(registerRequest, Role.TEAM);
	}

}
