package com.learn.services.userservice.entity;

import com.learn.services.userservice.dto.RegisterRequest;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static User fromDomain(String username, String email, Role role){
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setRole(role);
        return user;
    }
}
