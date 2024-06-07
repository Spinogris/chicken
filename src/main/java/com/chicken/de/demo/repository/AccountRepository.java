package com.chicken.de.demo.repository;

import com.chicken.de.demo.entity.acount.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT p FROM Account  p WHERE LOWER(p.lastName) LIKE LOWER(CONCAT('%', :search, '%')) " +
    "OR LOWER(p.firstName) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Account> searchAccountsByAll(@Param("search") String search);

    Optional<Account> findByAccountPersonalData_Name(String name);

    Optional<Account> findAccountByAccountPersonalData_Email(String email);

}
