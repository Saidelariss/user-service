package com.learn.services.userservice;

import com.learn.services.userservice.entity.Role;
import com.learn.services.userservice.entity.User;
import com.learn.services.userservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) throws Exception {
       // Object objet = Class.forName("com.learn.services.userservice.entity").newInstance();
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository, PasswordEncoder encoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = User.builder()
                        .username("admin")
                        .email("admin@example.com")
                        .password(encoder.encode("123456"))
                        .role(Role.ADMIN)
                        .build();
                userRepository.save(admin);
            }
        };
    }

}
