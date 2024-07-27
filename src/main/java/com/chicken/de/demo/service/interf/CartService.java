package com.chicken.de.demo.service.interf;


import com.chicken.de.demo.DTO.product.ProductResponseDTO;
import com.chicken.de.demo.entity.cart.Cart;

import java.util.Set;

public interface CartService {
    Cart addToCart(Long cartId, Long productId, int quantity);

    Cart removeFromCart(Long cart_id, Long product, int quantity);

    Set<ProductResponseDTO> getAllProducts(Long id);

}
