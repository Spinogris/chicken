package com.chicken.de.demo.repository;

import com.chicken.de.demo.entity.cart.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Long> {
    List<CartItems> findByCartId(Long cartId);
}
