package com.example.bankapp.features.accounts.services;


import com.example.bankapp.features.accounts.entities.AccountEntity;
import com.example.bankapp.features.accounts.entities.AccountType;

import java.util.List;

public interface AccountService {
    void create(AccountType accountType, Long accountID);
    void deposit(double amount, String accountID);
    void withdraw(double amount, String accountID);
    List<AccountEntity> getAll();
    void delete(String accountID);
}
