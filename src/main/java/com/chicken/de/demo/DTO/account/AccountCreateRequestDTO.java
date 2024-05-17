package com.chicken.de.demo.DTO.account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class AccountCreateRequestDTO {
    @NotBlank
    @Size(min = 2, max = 16)
    public String firstName;
    @NotBlank
    @Size(min = 2, max = 16)
    public String lastName;
    @NonNull
    @Email
    public String email;
    @NonNull
    @Pattern(regexp = "ˆ[0-9\\-\\\\\\s]+$", message = "invalid phone number!")
    public String phoneNumber;
    @NonNull
    public String city;

}
