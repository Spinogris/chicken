package com.chicken.de.demo.mapper;

import com.chicken.de.demo.DTO.account.AccountCreateRequestDTO;
import com.chicken.de.demo.DTO.account.AccountDTO;
import com.chicken.de.demo.DTO.account.AccountResponceDTO;
import com.chicken.de.demo.entity.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountResponceDTO toDTO(Account account);

    Account toEntity(AccountCreateRequestDTO accountCreateRequestDTO);

    List<AccountResponceDTO> allToDTO(List<Account> accounts);
}
