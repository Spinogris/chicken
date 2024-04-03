package com.chicken.de.demo.service.impl;

import com.chicken.de.demo.entity.Account;
import com.chicken.de.demo.repository.AccountRepository;
import com.chicken.de.demo.service.interf.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private final AccountService accountService;

    @Override
    public Account saveAccount(Account account) {
        accountRepository.save(account);
        return account;
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.getReferenceById(id);
    }

    @Override
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
}
