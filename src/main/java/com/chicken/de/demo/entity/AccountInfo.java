package com.chicken.de.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account_info")
@ToString
@Entity
public class AccountInfo {

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

    @OneToOne(mappedBy = "id")
    @Column(name = "role")
    private Set<Role> role;

    @OneToOne(mappedBy = "accountInfo")
    private AccountInfo accountInfo;

}
