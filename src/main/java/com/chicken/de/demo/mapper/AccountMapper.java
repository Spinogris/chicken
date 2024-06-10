package com.chicken.de.demo.mapper;

import com.chicken.de.demo.DTO.account.AccountAdminResponceDTO;
import com.chicken.de.demo.DTO.account.AccountCreateRequestDTO;
import com.chicken.de.demo.DTO.account.AccountResponceDTO;
import com.chicken.de.demo.entity.acount.Account;
import com.chicken.de.demo.entity.acount.AccountPersonalData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper//(componentModel = "spring") // с componentModel = "spring" не корректно работает
public interface AccountMapper {

    AccountResponceDTO toDTO(Account account);

    @Mapping(target = "accountPersonalData", ignore = true)
    Account toEntity(AccountCreateRequestDTO accountCreateRequestDTO);

    List<AccountResponceDTO> allToDTO(List<Account> accounts);

    AccountAdminResponceDTO toAdminDTO(AccountPersonalData accountPersonalData);

}
