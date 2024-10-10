package com.eight.bittube.dto;

import com.eight.bittube.model.Role;

public class UserDTO {

    private String firstName;

    private String lastName;

    private String username;

    private Role role;

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String username, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }    


}