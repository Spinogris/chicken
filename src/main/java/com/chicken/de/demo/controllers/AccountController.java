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

    //    @Autowired
    private final AccountService accountService;

    private final AuthenticationService authenticationService;

    private final PasswordEncoder passwordEncoder;

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "регистрация пользователя", description = "Доступ ROLE_ADMIN")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/auth/registration")
    public AccountResponceDTO saveAccount(@Valid @RequestBody AccountCreateRequestDTO account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountService.saveAccount(account);
    }


    @GetMapping("/{id}")
    public AccountResponceDTO getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<AccountResponceDTO> allAccounts() {
        return accountService.getAllAccounts();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public AccountResponceDTO removeAccountById(@PathVariable Long id) {
        return accountService.removeAccountById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN, ROLE_MANAGER')")
    @GetMapping("/search")
    public List<AccountResponceDTO> searchAccounts(@RequestParam String search) {
        return accountService.searchAccounts(search);
    }

    @PostMapping("/login")
    public JwtAuthenticationResponse login(@RequestBody SignInRequest request) {
        return authenticationService.authenticate(request);
    }
}
