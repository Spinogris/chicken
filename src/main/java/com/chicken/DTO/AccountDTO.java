package com.chicken.DTO;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
public class AccountDTO {
    @NonNull
    public String firstName;
    @NonNull
    public String lastName;
    @NonNull
    @Email
    public String email;
    @NonNull
    public String phoneNumber;
    @NonNull
    public String city;

}
