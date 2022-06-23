package com.example.bankapp.features.accounts.services;

import com.example.bankapp.features.accounts.entities.AccountEntity;
import com.example.bankapp.features.accounts.entities.AccountType;
import com.example.bankapp.features.accounts.errors.AccountNotFound;
import com.example.bankapp.features.accounts.errors.WithdrawNotAllowed;
import com.example.bankapp.features.accounts.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    

    @Override
    public void create(AccountType accountType, Long accountID) {
        AccountEntity accountEntity = new AccountEntity();
        String accountNumber = String.format("%03d%06d", 1, accountID);
        accountEntity.setId(accountNumber);
        accountEntity.setAccountType(accountType);
        accountEntity.setWithdrawAllowed(!accountType.equals(AccountType.FIXED));
        accountRepository.save(accountEntity);
    }

    @Override
    public void deposit(double amount, String accountID) {
        accountRepository.findById(accountID).orElseThrow(() -> new AccountNotFound(accountID));
        AccountEntity accountEntity = accountRepository.getAccountEntityById(accountID);
        accountEntity.setBalance(accountEntity.getBalance() + amount);
        accountRepository.save(accountEntity);
    }

    @Override
    public void withdraw(double amount, String accountID) {
        accountRepository.findById(accountID).orElseThrow(() -> new AccountNotFound(accountID));
        AccountEntity accountEntity = accountRepository.getAccountEntityById(accountID);
        if (amount <= accountEntity.getBalance() && accountEntity.isWithdrawAllowed())
            accountEntity.setBalance(accountEntity.getBalance() - amount);
        else throw new WithdrawNotAllowed(accountID);
        accountRepository.save(accountEntity);
    }

    @Override
    public List<AccountEntity> getAll() {
        return Streamable.of(accountRepository.findAll()).toList();
    }

    @Override
    public void delete(String accountID) {
        accountRepository.findById(accountID).orElseThrow(() -> new AccountNotFound(accountID));
        accountRepository.deleteById(accountID);
    }
}
