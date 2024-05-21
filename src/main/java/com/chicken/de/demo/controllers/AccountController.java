package com.chicken.de.demo.controllers;

import com.chicken.de.demo.DTO.account.AccountCreateRequestDTO;
import com.chicken.de.demo.DTO.account.AccountResponceDTO;
import com.chicken.de.demo.service.interf.AccountService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tags(@Tag(name = "account"))
@RestController
@RequestMapping("/chicken/accounts")
public class AccountController {
    //    @Operation(summary = "Регистрация пользователя", description = "Доступно всем. По умолчанию роль - USER")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201",
//                    description = "Пользователь зарегистрирован",
//                    content = @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = AccountResponceDTO.class))),
//            @ApiResponse(responseCode = "400",
//                    description = "Ошибка валидации",
//                    content = @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = ValidationErrorsDto.class))),
//            @ApiResponse(responseCode = "409",
//                    description = "Пользователь с таким email уже есть",
//                    content = @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = StandardResponseDto.class))),
//    })
    @Autowired
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "регистрация пользователя", description = "Доступ ROLE_ADMIN")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/auth/registration")
    public AccountResponceDTO saveAccount(@Valid @RequestBody AccountCreateRequestDTO account) {
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
}
