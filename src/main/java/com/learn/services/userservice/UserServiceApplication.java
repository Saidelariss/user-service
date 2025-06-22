package com.learn.services.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) throws Exception {
       // Object objet = Class.forName("com.learn.services.userservice.entity").newInstance();
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
