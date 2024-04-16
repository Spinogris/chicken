package com.chicken.de.demo.service.interf;


import com.chicken.de.demo.DTO.ProductDTO;
import com.chicken.de.demo.entity.Cart;

public interface CartService {
    Cart addToCart(ProductDTO product, int quantity);

    Cart removeFromCart(ProductDTO product, int quantity);

}
