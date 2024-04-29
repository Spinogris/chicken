package com.chicken.de.demo.mapper;

import com.chicken.de.demo.DTO.AccountDTO;
import com.chicken.de.demo.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account toEntity(AccountDTO accountDTO);

    AccountDTO toDTO(Account saveAcc);

    List<AccountDTO> toDTOList(List<Account> allAccounts);
}
