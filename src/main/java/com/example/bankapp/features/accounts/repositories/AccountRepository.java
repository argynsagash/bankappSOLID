package com.example.bankapp.features.accounts.repositories;

import com.example.bankapp.features.accounts.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {

    AccountEntity getAccountEntityById(String id);

}
