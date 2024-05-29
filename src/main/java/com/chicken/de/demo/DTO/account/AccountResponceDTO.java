package com.chicken.de.demo.DTO.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountResponceDTO {
    public String firstName;
    @JsonInclude(JsonInclude.Include.NON_NULL) //не показывает поле если оно равно NULL
    public String lastName;
    public String email;
    public String phoneNumber;
    public String city;

}
