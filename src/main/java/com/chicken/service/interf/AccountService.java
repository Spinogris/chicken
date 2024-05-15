package com.chicken.service.interf;

import com.chicken.entity.Account;

import java.util.List;

public interface AccountService {

    Account saveAccount(Account account);
    Account getAccountById(Long id);

    List<Account> getAllAccounts();

    Account removeAccountById(Long id);
}
