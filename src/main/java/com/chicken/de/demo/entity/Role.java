package com.chicken.de.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Table
@Entity(name = "roles")
@ToString(exclude = "accountPersonalData")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "account_personal_data_id", nullable = false)
    private AccountPersonalData accountPersonalData;

}
