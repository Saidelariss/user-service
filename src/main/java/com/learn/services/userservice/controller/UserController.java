package com.learn.services.userservice.controller;

import com.learn.services.userservice.dto.AuthRequest;
import com.learn.services.userservice.dto.AuthResponse;
import com.learn.services.userservice.dto.RegisterRequest;
import com.learn.services.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/auth/login")
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest){
           return userService.authenticateUSer(authRequest);
    }

    @PostMapping("/auth/register")
    public void register(@RequestBody RegisterRequest request){
        userService.registerUser(request);
    }
}
