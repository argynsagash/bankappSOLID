package com.example.bankapp.features.users.controller;

import com.example.bankapp.features.users.entities.UserEntity;
import com.example.bankapp.features.users.models.AuthRequest;
import com.example.bankapp.features.users.models.AuthResponse;
import com.example.bankapp.features.users.models.RegistrationRequest;
import com.example.bankapp.features.users.services.UserServiceImpl;
import com.example.bankapp.security.jwt.JwtProvider;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@SecurityRequirement(name = "basicauth")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceimpl;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationRequest registrationRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword(registrationRequest.getPassword());
        userEntity.setLogin(registrationRequest.getLogin());
        userServiceimpl.saveUser(userEntity);
        return "ok";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        UserEntity userEntity = userServiceimpl.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getLogin());
        return new AuthResponse(token);
    }

    @GetMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }
}
