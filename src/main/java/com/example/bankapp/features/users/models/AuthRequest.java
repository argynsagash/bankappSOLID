package com.example.bankapp.features.users.models;

import lombok.Data;

@Data
public class AuthRequest {
    private String login;
    private String password;
}
