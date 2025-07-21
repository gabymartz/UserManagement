package com.example.user.management.service;

import com.example.user.management.dto.LoginResponse;
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

    public ResponseEntity<LoginResponse> validateCredentials(String user, String password){
        Optional<UserApp> userOptional = userRepository.findByUsername(user);

        if(userOptional.isPresent()) {
            UserApp savedUserApp = userOptional.get();
            if(savedUserApp.getPassword().equals(password)){
                return new ResponseEntity<>(new LoginResponse("Login Successful"), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new LoginResponse("Wrong Credentials"),HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(new LoginResponse("Wrong Credentials"),HttpStatus.BAD_REQUEST);
        }
    }
}

