package com.example.bankapp.features.accounts.controller;


import com.example.bankapp.core.Bank;
import com.example.bankapp.features.accounts.entities.AccountEntity;
import com.example.bankapp.features.accounts.entities.AccountType;
import com.example.bankapp.features.accounts.services.AccountService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@SecurityRequirement(name = "basicauth")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    Bank bank;

    @GetMapping()
    public List<AccountEntity> getAll() {
        return accountService.getAll();
    }

    @PostMapping("/create")
    public String create(AccountType accountType) {
        bank.createAccount(accountType);
        return "Bank account created";
    }

    @PostMapping("/deposit")
    public String deposit(Double amount, String accountID) {
        accountService.deposit(amount, accountID);
        return String.format("%.2f transferred to %s account", amount, accountID);
    }

    @PostMapping("/withdraw")
    public String withdraw(Double amount, String accountID) {
        accountService.withdraw(amount, accountID);
        return String.format("%.2f transferred from %s account", amount, accountID);
    }

    @DeleteMapping()
    public String delete(String accountID) {
        accountService.delete(accountID);
        return String.format("Account %s deleted", accountID);
    }
}
