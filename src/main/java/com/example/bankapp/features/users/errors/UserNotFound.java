package com.example.bankapp.features.users.errors;

public class UserNotFound extends RuntimeException {

    public UserNotFound(Long id) {
        super(String.format("Could not find user %d", id));
    }
}
