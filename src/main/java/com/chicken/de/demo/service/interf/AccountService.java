package com.chicken.de.demo.service.interf;

import com.chicken.de.demo.DTO.account.AccountCreateRequestDTO;
import com.chicken.de.demo.DTO.account.AccountResponceDTO;

import java.util.List;

public interface AccountService {

    AccountResponceDTO saveAccount(AccountCreateRequestDTO account);

    AccountResponceDTO getAccountByEmail(String email);

    List<AccountResponceDTO> getAllAccounts();

    AccountResponceDTO removeAccountById(Long id);

    List<AccountResponceDTO> searchAccounts(String name);
}
