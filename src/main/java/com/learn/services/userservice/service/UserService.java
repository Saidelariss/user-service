package com.learn.services.userservice.service;

import com.learn.services.userservice.dto.AuthRequest;
import com.learn.services.userservice.dto.AuthResponse;
import com.learn.services.userservice.dto.RegisterRequest;
import com.learn.services.userservice.entity.User;
import com.learn.services.userservice.repository.UserRepository;
import com.learn.services.userservice.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public AuthResponse authenticateUSer(AuthRequest authRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        User user = userRepository.findByUsername(authRequest.getUsername()).get();
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(jwtUtils.generateToken(user.getUsername(), user.getEmail(), user.getRole().name()));

        return authResponse;
    }

    public void registerUser(RegisterRequest request) {

        User user = User.fromDomain(request.getUsername(), request.getEmail(), request.getRole());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
    }
}
