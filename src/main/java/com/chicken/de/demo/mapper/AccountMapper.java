package com.chicken.de.demo.mapper;

import com.chicken.de.demo.DTO.account.AccountCreateRequestDTO;
import com.chicken.de.demo.DTO.account.AccountResponceDTO;
import com.chicken.de.demo.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountResponceDTO toDTO(Account account);

    @Mapping(target = "accountPersonalData", ignore = true)
    Account toEntity(AccountCreateRequestDTO accountCreateRequestDTO);

    List<AccountResponceDTO> allToDTO(List<Account> accounts);
}
