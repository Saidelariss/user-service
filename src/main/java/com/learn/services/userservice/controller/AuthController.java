package com.learn.services.userservice.controller;

import com.learn.services.userservice.dto.AuthRequest;
import com.learn.services.userservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/auth/login")
    public void authenticate(@RequestBody AuthRequest authRequest){
            authService.authenticateUSer(authRequest);
    }
}
