package com.learning.questionsApp.controllers;

import com.learning.questionsApp.Security.JWTUtil;
import com.learning.questionsApp.dto.Response.Login;
import com.learning.questionsApp.entity.User;
import com.learning.questionsApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.sasl.AuthenticationException;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepo userRepo;
    @Autowired private JWTUtil jwtUtil;
    @Autowired private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public Map<String, Object> loginHandler(@RequestBody Login login) throws AuthenticationException {

//        check if user exists in db
        User user = userRepo.findByEmail(login.getEmail()).orElseThrow();

//        check if password matches
        if(!passwordEncoder.matches(login.getPassword(), user.getPassword())){
            return Map.of(
                    "message", "Invalid Credentials"
            );
        }

//        encode password
        String encodedPass = passwordEncoder.encode(login.getPassword());
        login.setPassword(encodedPass);
        String token = jwtUtil.generateToken(login.getEmail());
        return Collections.singletonMap("jwt-token", token);
    }

}