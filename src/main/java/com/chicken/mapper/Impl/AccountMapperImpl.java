package com.chicken.mapper.Impl;

import com.chicken.entity.Account;
import com.chicken.mapper.AccountMapper;
import com.chicken.DTO.AccountDTO;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account toEntity(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public AccountDTO toDTO(Account saveAcc) {
        return null;
    }

    @Override
    public List<AccountDTO> toDTOList(List<Account> allAccounts) {
        return null;
    }
}
