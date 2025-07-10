package com.example.user.management.service;

import com.example.user.management.entity.UserApp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final com.example.user.management.repository.userRepository userRepository;

    public LoginService(com.example.user.management.repository.userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> validateCredentials(String user, String password) {
        Optional<UserApp> userOpt = userRepository.findByUsername(user);

        if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.OK).body("Login Successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials");
        }
    }
}
