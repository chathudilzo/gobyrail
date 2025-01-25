package com.example.gobyrail.service;


import com.example.gobyrail.repository.UserRepository;
import com.example.gobyrail.entity.Role;
import com.example.gobyrail.entity.User;
import com.example.gobyrail.entity.UserRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final String SECRET_KEY = "yoursecretkeyshouldbe256bitslong1235687777777777777777777777777777777777777";

    public String register(UserRequest userRequest) {
        Optional<User> existingUser = userRepository.findByEmail(userRequest.getEmail());
        if (existingUser.isPresent()) {
            return "Email is already in use";
        }


        User user = new User();

        user.setFirstname(userRequest.getFirstName());
        user.setLastname(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPasswordHash(passwordEncoder.encode(userRequest.getPassword()));
        user.setRole(Role.USER);

        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            return  "Error saving user to the database" +e ;
        }
        return "User registered successfully";
    }


    public ResponseEntity<Map<String, Object>> login(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPasswordHash())) {
                String token = Jwts.builder()
                        .setSubject(user.getEmail())
                        .claim("role", user.getRole().name())
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                        .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                        .compact();

                // Create a map and return the response as a JSON object
                Map<String, Object> response = new HashMap<>();
                response.put("token", token);
                response.put("firstName", user.getFirstname());
                response.put("lastName", user.getLastname());
                response.put("email", user.getEmail());
                response.put("role", user.getRole().name());

                return ResponseEntity.ok(response);
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }
}



