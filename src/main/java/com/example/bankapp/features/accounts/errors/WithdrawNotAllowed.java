package com.example.bankapp.features.accounts.errors;

public class WithdrawNotAllowed extends RuntimeException {
    public WithdrawNotAllowed(String id) {
        super(String.format("Account with ID:%s withdraw not allowed", id));
    }
}

