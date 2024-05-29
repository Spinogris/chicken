package com.chicken.de.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "accounts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Account {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_personal_data_id", referencedColumnName = "id")
    private AccountPersonalData accountPersonalData;

    public Account(Long id,
                   String firstName,
                   String lastName,
                   AccountPersonalData accountPersonalData) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountPersonalData = accountPersonalData;
    }
}
