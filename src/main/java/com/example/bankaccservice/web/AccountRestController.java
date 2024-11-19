package com.example.bankaccservice.web;

import com.example.bankaccservice.dto.BankAccountRequestDTO;
import com.example.bankaccservice.dto.BankAccountResponseDTO;
import com.example.bankaccservice.entities.BankAccount;
import com.example.bankaccservice.mappers.AccountMapper;
import com.example.bankaccservice.repos.BankAccountRepository;
import com.example.bankaccservice.repos.BankAccountRepository;
import com.example.bankaccservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
   private AccountService  accountService;


    private AccountMapper accountMapper;
    private  BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository, AccountMapper accountMapper, AccountService accountService) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountMapper = accountMapper;
        this.accountService = accountService;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Could not find BankAccount"));
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){

        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
       BankAccount account = bankAccountRepository.findById(id).orElseThrow();
       if(bankAccount.getBalance()!=null ) account.setBalance(bankAccount.getBalance());
       if(bankAccount.getCreateAt()!=null ) account.setCreateAt(bankAccount.getCreateAt());
       if(bankAccount.getType()!=null ) account.setType(bankAccount.getType());
       if(bankAccount.getCurrency()!=null ) account.setCurrency(bankAccount.getCurrency());
       return bankAccountRepository.save(account);


}
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount (@PathVariable String id) {
         bankAccountRepository.deleteById(id);
    }
}
