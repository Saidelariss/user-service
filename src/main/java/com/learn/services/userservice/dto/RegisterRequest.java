package com.learn.services.userservice.dto;

import com.learn.services.userservice.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private Role role;
}
