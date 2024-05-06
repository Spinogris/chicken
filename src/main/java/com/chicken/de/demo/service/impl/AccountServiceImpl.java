package com.chicken.de.demo.service.impl;

import com.chicken.de.demo.entity.Account;
import com.chicken.de.demo.mapper.AccountMapper;
import com.chicken.de.demo.repository.AccountRepository;
import com.chicken.de.demo.service.interf.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private final AccountRepository accountRepository;


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

    @Override
    public Account removeAccountById(Long id){
        Optional<Account> remAccById = accountRepository.findById(id);
        if (remAccById.isPresent()){
            remAccById.get();
            accountRepository.deleteById(id);
        } else {
            System.out.println("Account with id " + id + " is empty!");
        }
        return null;
    }

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
