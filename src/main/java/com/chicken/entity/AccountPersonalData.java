package com.chicken.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account_info")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AccountPersonalData {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "accountPersonalData")
    private Set<Role> role;

    @OneToOne(mappedBy = "accountPersonalData")
    private Account account;

}
