package com.example.gobyrail.controller;

import com.example.gobyrail.service.UserService;
import com.example.gobyrail.entity.LoginRequest;
import com.example.gobyrail.entity.UserRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> register(@RequestBody UserRequest userRequest) {
        String response = userService.register(userRequest);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest.getEmail(), loginRequest.getPassword());
    }
}
