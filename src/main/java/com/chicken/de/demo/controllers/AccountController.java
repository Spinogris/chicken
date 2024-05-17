package com.chicken.de.demo.controllers;

import com.chicken.de.demo.DTO.account.AccountCreateRequestDTO;
import com.chicken.de.demo.DTO.account.AccountResponceDTO;
import com.chicken.de.demo.service.interf.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chicken/accounts")
public class AccountController {

    @Autowired
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/save")
    public AccountResponceDTO saveAccount(@Valid @RequestBody AccountCreateRequestDTO account){
        return accountService.saveAccount(account);
    }

    @GetMapping("/{id}")
    public AccountResponceDTO getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/all")
    public List<AccountResponceDTO> allAccounts(){
        return accountService.getAllAccounts();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public AccountResponceDTO removeAccountById(@PathVariable Long id){
        return accountService.removeAccountById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN, ROLE_MANAGER')")
    @GetMapping("/search")
    public List<AccountResponceDTO> searchAccounts(@RequestParam String search){
        return accountService.searchAccounts(search);
    }
}
