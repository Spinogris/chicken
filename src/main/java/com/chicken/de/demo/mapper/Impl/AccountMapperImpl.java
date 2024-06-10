package com.chicken.de.demo.mapper.Impl;

import com.chicken.de.demo.DTO.account.AccountAdminResponceDTO;
import com.chicken.de.demo.DTO.account.AccountCreateRequestDTO;
import com.chicken.de.demo.DTO.account.AccountResponceDTO;
import com.chicken.de.demo.entity.acount.Account;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.chicken.de.demo.entity.acount.AccountPersonalData;
import com.chicken.de.demo.mapper.AccountMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountMapperImpl implements AccountMapper {
    public AccountMapperImpl() {
    }

    public AccountResponceDTO toDTO(Account account) {
        if (account == null) {
            return null;
        } else {
            AccountResponceDTO accountResponceDTO = new AccountResponceDTO();
            accountResponceDTO.setFirstName(account.getFirstName());
            accountResponceDTO.setLastName(account.getLastName());
            accountResponceDTO.setEmail(account.getAccountPersonalData().getEmail());
            accountResponceDTO.setCity(account.getAccountPersonalData().getCity());
            accountResponceDTO.setPhoneNumber(account.getAccountPersonalData().getPhoneNumber());
            return accountResponceDTO;
        }
    }

    public AccountAdminResponceDTO toAdminDTO(AccountPersonalData accountPersonalData) {
        if (accountPersonalData == null) {
            return null;
        } else {
            AccountAdminResponceDTO accountAdminResponceDTO = new AccountAdminResponceDTO();
            accountAdminResponceDTO.setName(accountPersonalData.getName());
            accountAdminResponceDTO.setEmail(accountPersonalData.getEmail());
            accountAdminResponceDTO.setPhoneNumber(accountPersonalData.getPhoneNumber());
            accountAdminResponceDTO.setCity(accountPersonalData.getCity());
            accountAdminResponceDTO.setCart(accountPersonalData.getCart());
            accountAdminResponceDTO.setRoles(accountPersonalData.getRoles());

            return accountAdminResponceDTO;
        }
    }

    public Account toEntity(AccountCreateRequestDTO accountCreateRequestDTO) {
        if (accountCreateRequestDTO == null) {
            return null;
        } else {
            Account account = new Account();
            account.setFirstName(accountCreateRequestDTO.getFirstName());
            account.setLastName(accountCreateRequestDTO.getLastName());
            return account;
        }
    }

    public List<AccountResponceDTO> allToDTO(List<Account> accounts) {
        if (accounts == null) {
            return null;
        } else {
            List<AccountResponceDTO> list = new ArrayList(accounts.size());
            Iterator var3 = accounts.iterator();

            while(var3.hasNext()) {
                Account account = (Account)var3.next();
                list.add(this.toDTO(account));
            }

            return list;
        }
    }
}