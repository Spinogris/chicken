package com.chicken.de.demo.service.interf;


import com.chicken.de.demo.entity.Cart;
import com.chicken.de.demo.entity.Product;

import java.util.List;

public interface CartService   {
    Cart addToCart(Product product, int quantity);
//Cart removeFromCart(Long productId);

}
