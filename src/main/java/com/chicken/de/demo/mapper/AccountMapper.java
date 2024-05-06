package com.chicken.de.demo.mapper;

import com.chicken.de.demo.DTO.AccountDTO;
import com.chicken.de.demo.entity.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    Account toEntity(AccountDTO accountDTO);

    AccountDTO toDTO(Account saveAcc);

    List<AccountDTO> toDTOList(List<Account> allAccounts);
}
