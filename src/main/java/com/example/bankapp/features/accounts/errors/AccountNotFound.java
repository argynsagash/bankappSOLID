package com.example.bankapp.features.accounts.errors;

public class AccountNotFound extends RuntimeException {
    public AccountNotFound(String id) {
        super(String.format("Could not find account %s", id));
    }
}
