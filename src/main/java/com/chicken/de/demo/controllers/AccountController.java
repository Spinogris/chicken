package com.chicken.de.demo.controllers;

import com.chicken.de.demo.DTO.AccountDTO;
import com.chicken.de.demo.entity.Account;
import com.chicken.de.demo.mapper.AccountMapper;
import com.chicken.de.demo.service.interf.AccountService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chicken/accounts")
public class AccountController {

    @Autowired
    private final AccountService accountService;
    @Autowired
    private final AccountMapper accountMapper;

    @PostMapping("/save")
    public ResponseEntity<AccountDTO> saveAccount(@RequestBody AccountDTO accountDTO){
        Account account = accountMapper.toEntity(accountDTO);
        Account saveAcc = accountService.saveAccount(account);
        AccountDTO saveAccDTO = accountMapper.toDTO(saveAcc);
        return ResponseEntity.ok(saveAccDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id){
        Account accountById = accountService.getAccountById(id);
        AccountDTO accountDTO = accountMapper.toDTO(accountById);
        return ResponseEntity.ok(accountDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AccountDTO>> allAccounts(){
        List<Account> allAccounts = accountService.getAllAccounts();
        List<AccountDTO> allAccountsDTO = accountMapper.toDTOList(allAccounts);
        return ResponseEntity.ok(allAccountsDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AccountDTO> removeAccountById(@PathVariable Long id){
        Account remAccById = accountService.removeAccountById(id);
        AccountDTO remAccByIdDTO = accountMapper.toDTO(remAccById);
        return ResponseEntity.ok(remAccByIdDTO);
    }

    public AccountController(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }
}
