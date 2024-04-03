package com.chicken.de.demo.controllers;

import com.chicken.de.demo.entity.Account;
import com.chicken.de.demo.service.interf.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chicken/accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/save")
    public ResponseEntity<Account> saveAccount(@RequestBody Account account){
        Account saveAcc = accountService.saveAccount(account);
        return ResponseEntity.ok(saveAcc);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id){
        Account accountById = accountService.getAccountById(id);
        return new ResponseEntity<>(accountById, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> allAccounts(){
        List<Account> allAccounts = (List<Account>) accountService.getAllAccounts();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> removeAccountById(@PathVariable Long id){
        Account remAccById = accountService.removeAccountById(id);
        return new ResponseEntity<>(remAccById, HttpStatus.OK);
    }
}
