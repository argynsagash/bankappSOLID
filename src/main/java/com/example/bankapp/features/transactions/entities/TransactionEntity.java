package com.example.bankapp.features.transactions.entities;

import com.example.bankapp.features.accounts.entities.AccountEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "transaction")
@Data
public class TransactionEntity {


    @Id
    private Long id;
    private String transactionInfo;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity accountEntity;


}