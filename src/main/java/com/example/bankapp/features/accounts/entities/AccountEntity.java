package com.example.bankapp.features.accounts.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "account")
@Data
public class AccountEntity {
    @Id
    private String id;
    @Column
    private AccountType accountType;
    @Column
    private double balance;
    @Column
    private boolean withdrawAllowed;


}
