package com.example.bankapp.features.transactions.entities;

import com.example.bankapp.features.accounts.entities.AccountEntity;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "transaction")
@Data
public class TransactionEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionInfo;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity accountEntity;


}