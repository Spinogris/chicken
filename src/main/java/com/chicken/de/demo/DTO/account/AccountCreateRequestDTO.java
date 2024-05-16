package com.chicken.de.demo.DTO.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCreateRequestDTO {
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNumber;
    public String city;

}
