package com.chicken.de.demo.controllers;

import com.chicken.de.demo.entity.Account;
import com.chicken.de.demo.service.interf.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chicken/accounts")
public class AccountController {

    private final AccountService accountService;

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
}
