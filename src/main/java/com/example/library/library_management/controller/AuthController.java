package com.example.library.library_management.controller;

import com.example.library.library_management.model.User;
import com.example.library.library_management.repository.UserRepository;
import com.example.library.library_management.config.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return "User registered";
    }

    @PostMapping("/signin")
    public String signin(@RequestBody User user) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        User dbUser = repo.findByUsername(user.getUsername()).get();

        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(dbUser.getUsername())
                .password(dbUser.getPassword())
                .roles(dbUser.getRole().name().replace("ROLE_", ""))
                .build();

        return jwtUtil.generateToken(userDetails);
    }
}
