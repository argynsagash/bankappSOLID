package com.example.bankapp.features.transactions.services;

import com.example.bankapp.features.transactions.entities.TransactionEntity;
import com.example.bankapp.features.transactions.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<TransactionEntity> getByAccountID(String accountID) {
        return transactionRepository.findAllByAccountEntity_Id(accountID);
    }
}
