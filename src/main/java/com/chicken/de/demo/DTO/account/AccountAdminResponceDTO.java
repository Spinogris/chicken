package com.chicken.de.demo.DTO.account;

import com.chicken.de.demo.entity.Role;
import com.chicken.de.demo.entity.cart.Cart;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AccountAdminResponceDTO {
    public String name;
    public String email;
    public String phoneNumber;
    public String city;
    public Set<Role> roles;
    public Cart cart;

}
