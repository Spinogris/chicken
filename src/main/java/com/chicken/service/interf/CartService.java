package com.chicken.service.interf;


import com.chicken.DTO.ProductDTO;
import com.chicken.entity.Cart;

public interface CartService {
    Cart addToCart(ProductDTO product, int quantity);

    Cart removeFromCart(ProductDTO product, int quantity);

}
