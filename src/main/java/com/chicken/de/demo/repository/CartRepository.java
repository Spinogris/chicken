package com.chicken.de.demo.repository;

import com.chicken.de.demo.entity.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByAccountPersonalDataId(Long accountPersonalDataId);
}
