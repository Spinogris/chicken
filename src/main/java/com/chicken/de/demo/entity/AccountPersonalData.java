package com.chicken.de.demo.entity;

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

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @Column(name = "city",nullable = false)
    private String city;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "accountPersonalData")
    private Set<Role> role;

    @OneToOne(mappedBy = "accountPersonalData")
    private Account account;

}
