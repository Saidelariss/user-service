package com.learn.services.userservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {
    static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        String s = """
                {
                "name":"Said",
                "age":"322332"
                }
                """;
        Object o = objectMapper.readValue(s, Object.class);
        // Object objet = Class.forName("com.learn.services.userservice.entity").newInstance();
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
