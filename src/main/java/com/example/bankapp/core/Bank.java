package com.example.bankapp.core;

import com.example.bankapp.features.accounts.entities.AccountType;
import com.example.bankapp.features.accounts.services.AccountService;
import org.springframework.stereotype.Component;

@Component
public class Bank {

    private long lastAccountNumber = 1;
    private AccountService accountService;

    public Bank(AccountService accountService) {
        this.accountService = accountService;
    }

    public void createAccount(AccountType accountType) {
        accountService.create(accountType, lastAccountNumber);
        incrementLastAccountNumber();
    }

    private void incrementLastAccountNumber() {
        this.lastAccountNumber = lastAccountNumber + 1;

    }
}
