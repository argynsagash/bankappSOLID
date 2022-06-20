package com.example.bankapp.features.users.models;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String login;
    private String password;
}
