package com.example.bankapp.features.transactions.services;

import com.example.bankapp.features.transactions.entities.TransactionEntity;

import java.util.List;

public interface TransactionService {
    List<TransactionEntity> getByAccountID(String accountID);
}
