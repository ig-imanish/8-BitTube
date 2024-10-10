package com.eight.bittube.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eight.bittube.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
