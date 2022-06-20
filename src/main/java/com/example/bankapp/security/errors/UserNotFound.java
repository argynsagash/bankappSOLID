package com.example.bankapp.security.errors;

public class UserNotFound extends RuntimeException{
    public UserNotFound(Long id) {
        super(String.format("Could not find user %d", id));
    }
}
