package com.chicken.de.demo.service.impl;

import com.chicken.de.demo.DTO.account.AccountCreateRequestDTO;
import com.chicken.de.demo.DTO.account.AccountResponceDTO;
import com.chicken.de.demo.entity.Account;
import com.chicken.de.demo.mapper.AccountMapper;
import com.chicken.de.demo.repository.AccountRepository;
import com.chicken.de.demo.service.interf.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private final AccountRepository accountRepository;
    @Autowired
    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    @Transactional
    public AccountResponceDTO saveAccount(AccountCreateRequestDTO accountDTO) {
        Account account = accountMapper.toEntity(accountDTO);
        Account saveAccount = accountRepository.save(account);
        return accountMapper.toDTO(saveAccount);
    }

    @Override
    public AccountResponceDTO getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account with id " + id + " not found!"));
        return accountMapper.toDTO(account);
    }

    @Override
    public List<AccountResponceDTO> getAllAccounts() {
        List<Account> accountList = accountRepository.findAll();
        return accountMapper.allToDTO(accountList);
    }

    @Override
    @Transactional
    public AccountResponceDTO removeAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account with id " + id + " not found!"));
        return accountMapper.toDTO(account);
    }

    @Override
    public List<AccountResponceDTO> searchAccountById(String name) {
        List<Account> accountList = accountRepository.searchAccountsByAll(name);
        return accountMapper.allToDTO(accountList);
    }
}
