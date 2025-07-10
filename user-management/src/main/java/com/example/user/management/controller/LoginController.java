package com.example.user.management.controller;
import com.example.user.management.service.LoginService;
import com.example.user.management.dto.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> processLogin(@RequestBody LoginRequest loginRequest) {
        return loginService.validateCredentials(loginRequest.getUser(), loginRequest.getPassword());
    }
}
