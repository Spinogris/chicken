package com.chicken.mapper;

import com.chicken.entity.Account;
import com.chicken.DTO.AccountDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {

    Account toEntity(AccountDTO accountDTO);

    AccountDTO toDTO(Account saveAcc);

    List<AccountDTO> toDTOList(List<Account> allAccounts);
}
