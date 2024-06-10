package com.chicken.de.demo.controllers;

import com.chicken.de.demo.DTO.account.AccountCreateRequestDTO;
import com.chicken.de.demo.DTO.account.AccountResponceDTO;
import com.chicken.de.demo.security.AuthenticationService;
import com.chicken.de.demo.security.model.JwtAuthenticationResponse;
import com.chicken.de.demo.security.model.SignInRequest;
import com.chicken.de.demo.service.interf.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tags(@Tag(name = "account"))
@RestController
@RequestMapping("/chicken/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    private final AuthenticationService authenticationService;

    private final PasswordEncoder passwordEncoder;

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "регистрация пользователя", description = "Доступ ALL")
    @PostMapping("/auth/registration")
    public AccountResponceDTO saveAccount(@Valid @RequestBody AccountCreateRequestDTO account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountService.saveAccount(account);
    }

    @Operation(summary = "Поиск USER по email", description = "Доступ у ROLE_ADMIN, ROLE_MANAGER")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
//    @PreAuthorize("permitAll()")
    @GetMapping("/getByEmail/{email}")
    public AccountResponceDTO getAccountByEmail(@PathVariable String email) {
        return accountService.getAccountByEmail(email);
    }

    @Operation(summary = "Просмотр всех USERS", description = "Доступно ROLE_ADMIN")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @PreAuthorize("permitAll()")
    @GetMapping("/getAllAccounts")
    public List<AccountResponceDTO> allAccounts() {
        return accountService.getAllAccounts();
    }

    @Operation(summary = "Удаление аккаунта", description = "Доступно ROLE_ADMIN")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @PreAuthorize("permitAll()")
    @DeleteMapping("/removeAccountById/{id}")
    public AccountResponceDTO removeAccountById(@PathVariable Long id) {
        return accountService.removeAccountById(id);
    }

    @Operation(summary = "Поиск аккаунта по name, last_name, email, telephone_number.", description = "Доступ у ROLE_ADMIN, ROLE_MANAGER")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
//@PreAuthorize("permitAll()")
    @GetMapping("/search")
    public List<AccountResponceDTO> searchAccounts(@RequestParam String search) {
        return accountService.searchAccounts(search);
    }

    @PostMapping("/login") // eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE3MTc3ODU2NjAsImV4cCI6MTcxNzkyOTY2MCwic3ViIjoidmxhZGlzbGF2Nzc3ODhAZ21haWwuY29tIn0.3a68f9ut-TX_YkxFak-E6vnVC-lF3F3s_AwAYLYteFKbi-xJf7vOLTbqjPlVOtxOSZKoFtaU_SBVwXgkpXVtVQ
    public JwtAuthenticationResponse login(@RequestBody SignInRequest request) {
        return authenticationService.authenticate(request);
    }

    @Operation(summary = "Поиск USER ROLES по email", description = "Доступ у ROLE_ADMIN")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @PreAuthorize("permitAll()")
    @GetMapping("/roles/{email}")
    public String getRoles(@PathVariable String email){
        return accountService.getRoles(email).toString();
    }
}
