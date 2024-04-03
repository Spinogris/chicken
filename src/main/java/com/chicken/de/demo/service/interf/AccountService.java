package com.chicken.de.demo.service.interf;

import com.chicken.de.demo.entity.Account;

import java.util.List;

public interface AccountService {

    Account saveAccount(Account account);
    Account getAccountById(Long id);

    List<Account> getAllAccounts();

    Account removeAccountById(Long id);
}
