package com.chicken.de.demo.service.interf;


import com.chicken.de.demo.entity.cart.Cart;

public interface CartService {
    Cart addToCart(Long cartId, Long productId, int quantity);

    Cart removeFromCart(Long cart_id, Long product, int quantity);

}
