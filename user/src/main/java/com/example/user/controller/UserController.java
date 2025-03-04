package com.example.user.controller;

import com.example.user.domain.UserDTO;
import com.example.user.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<UserDTO> getUserByUserName(@RequestParam("username") String username) {
        return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO username) {
        return new ResponseEntity<>(userService.createUser(username), HttpStatus.OK);
    }

    @DeleteMapping("/user")
    public ResponseEntity<String> deleteUserByUsername(@RequestParam String username) {
        return new ResponseEntity<>(userService.deleteUser(username), HttpStatus.OK);
    }

}
