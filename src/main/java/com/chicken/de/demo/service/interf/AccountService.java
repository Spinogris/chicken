package com.chicken.de.demo.service.interf;

import com.chicken.de.demo.DTO.account.AccountCreateRequestDTO;
import com.chicken.de.demo.DTO.account.AccountResponceDTO;
import com.chicken.de.demo.entity.Role;
import com.chicken.de.demo.entity.acount.AccountPersonalData;

import java.util.List;
import java.util.Set;

public interface AccountService {

    AccountResponceDTO saveAccount(AccountCreateRequestDTO account);

    AccountResponceDTO getAccountByEmail(String email);

    List<AccountResponceDTO> getAllAccounts();

    AccountResponceDTO removeAccountById(Long id);

    List<AccountResponceDTO> searchAccounts(String name);

    Set<Role> getRoles(String email);
}
