package com.eight.bittube.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.eight.bittube.model.Role;
import com.eight.bittube.model.User;

import java.util.Optional;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
    List<User> findByRole(Role role);
    @Override
    void deleteById(Integer id);
}
