package com.example.bankapp.features.transactions.controller;

import com.example.bankapp.features.transactions.entities.TransactionEntity;
import com.example.bankapp.features.transactions.services.TransactionService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@SecurityRequirement(name = "basicauth")
public class TransactionController {
    @Autowired
    TransactionService transactionService;


    @GetMapping()
    public List<TransactionEntity> getTransactionsByAccountID(String accountID) {
        return transactionService.getByAccountID(accountID);
    }
}
