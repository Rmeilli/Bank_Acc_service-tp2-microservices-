package com.example.bankaccservice.mappers;

import com.example.bankaccservice.dto.BankAccountResponseDTO;
import com.example.bankaccservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDTO responseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, responseDTO);
        return responseDTO;
    }
}
