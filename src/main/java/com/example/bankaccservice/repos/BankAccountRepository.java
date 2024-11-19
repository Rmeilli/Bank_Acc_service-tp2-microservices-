package com.example.bankaccservice.repos;

import com.example.bankaccservice.entities.BankAccount;
import com.example.bankaccservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    @RestResource(path="/byType")
    List<BankAccount> findByType(@Param("t") AccountType type);
}
