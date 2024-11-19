package com.example.bankaccservice.dto;

import com.example.bankaccservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor @NoArgsConstructor @Data @Builder

public class BankAccountRequestDTO {

    private Double balance;
    private String currency;
    private AccountType type;
}
