package com.example.user.domain;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class UserDTO {
    private String username;
    private String email;
    private String address;
}