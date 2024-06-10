package com.chicken.de.demo.service.impl;

import com.chicken.de.demo.DTO.account.AccountCreateRequestDTO;
import com.chicken.de.demo.DTO.account.AccountResponceDTO;
import com.chicken.de.demo.entity.Role;
import com.chicken.de.demo.entity.acount.Account;
import com.chicken.de.demo.entity.acount.AccountPersonalData;
import com.chicken.de.demo.entity.cart.Cart;
import com.chicken.de.demo.mapper.AccountMapper;
import com.chicken.de.demo.repository.AccountRepository;
import com.chicken.de.demo.repository.CartRepository;
import com.chicken.de.demo.service.interf.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService, UserDetailsService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    private final CartRepository cartRepository;

    @Override
    @Transactional
    public AccountResponceDTO saveAccount(AccountCreateRequestDTO accountDTO) {
        Account account = accountMapper.toEntity(accountDTO);

        AccountPersonalData personalData = new AccountPersonalData();
        personalData.setName(accountDTO.getLastName());
        personalData.setEmail(accountDTO.getEmail());
        personalData.setPhoneNumber(accountDTO.getPhoneNumber());
        personalData.setCity(accountDTO.getCity());
        personalData.setPassword(accountDTO.getPassword());

        account.setAccountPersonalData(personalData);

        Set<Role> roles = new HashSet<>();
        Role userRole = new Role();
        userRole.setRoleName("USER");
        userRole.setAccountPersonalData(personalData);
        roles.add(userRole);
        personalData.setRoles(roles);

        account.setAccountPersonalData(personalData);

        Cart cart = new Cart();
        cart.setAccountPersonalData(personalData);
        cartRepository.save(cart);
        personalData.setCart(cart);

        Account saveAccount = accountRepository.save(account);
        return accountMapper.toDTO(saveAccount);
    }

    @Override
    public AccountResponceDTO getAccountByEmail(String email) {
        Account account = accountRepository.findAccountByAccountPersonalData_Email(email)
                .orElseThrow(() -> new RuntimeException("Account with email " + email + " is absent"));
        return accountMapper.toDTO(account);
    }

    @Override
    public List<AccountResponceDTO> getAllAccounts() {
        List<Account> accountList = accountRepository.findAll();
        return accountMapper.allToDTO(accountList);
    }

    @Override
    @Transactional
    public AccountResponceDTO removeAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account with id " + id + " not found!"));
        accountRepository.deleteById(id);
        return accountMapper.toDTO(account);
    }

    @Override
    public List<AccountResponceDTO> searchAccounts(String request) {
        List<Account> accountList = accountRepository.searchAccountsByAll(request);
        return accountMapper.allToDTO(accountList);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AccountPersonalData accountPersonalData = accountRepository.findAccountByAccountPersonalData_Email(email)
                .orElseThrow(() -> new UsernameNotFoundException("Don't find user by email " + email))
                .getAccountPersonalData();
        if (accountPersonalData.getRoles() == null) {
            throw new UsernameNotFoundException("Account personal data is null for user with email " + email);
        }
        return User.builder()
                .username(accountPersonalData.getEmail())
                .password(accountPersonalData.getPassword())
                .roles(accountPersonalData.getRoles().stream()
                        .map(Role::getRoleName)
                        .toArray(String[]::new))
                .build();
    }

    public Set<Role> getRoles(String email) {
        Optional<Account> accountOptional = accountRepository.findAccountByAccountPersonalData_Email(email);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            return account.getAccountPersonalData().getRoles();
        } else
            return Collections.emptySet();
    }
}
