package com.example.user.service.impl;

import com.example.user.domain.UserDTO;
import com.example.user.entity.User;
import com.example.user.exception.NotFoundException;
import com.example.user.repo.UserRepository;
import com.example.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            UserDTO userDTO = UserDTO.builder()
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .address(user.getAddress())
                    .build();
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    @Override
    public UserDTO getUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        return UserDTO.builder()
                .username(user.get().getUsername())
                .email(user.get().getEmail())
                .address(user.get().getAddress())
                .build();
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        User newUser = User.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .address(user.getAddress())
                .build();
        userRepository.save(newUser);
        return user;
    }

    @Override
    public String deleteUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        try {
            userRepository.delete(user.get());
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
        return "User removed: " + user.get().getUsername();
    }
}
