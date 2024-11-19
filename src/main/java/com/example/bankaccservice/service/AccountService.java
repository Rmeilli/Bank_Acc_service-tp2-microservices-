package com.example.bankaccservice.service;

import com.example.bankaccservice.dto.BankAccountRequestDTO;
import com.example.bankaccservice.dto.BankAccountResponseDTO;
import com.example.bankaccservice.entities.BankAccount;
import org.springframework.stereotype.Service;

@Service
public interface AccountService  {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
