package com.example.bankapp.features.transactions.repositories;

import com.example.bankapp.features.transactions.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository <TransactionEntity,Long>{
    List<TransactionEntity> findAllByAccountEntity_Id(String accountID);
}
