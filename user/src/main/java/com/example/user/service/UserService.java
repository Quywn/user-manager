package com.example.user.service;

import com.example.user.domain.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
    UserDTO getUser(String username);
    UserDTO createUser(UserDTO user);
    String deleteUser(String username);
}
