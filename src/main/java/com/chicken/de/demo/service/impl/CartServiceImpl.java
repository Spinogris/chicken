package com.chicken.de.demo.service.impl;

import com.chicken.de.demo.entity.Cart;
import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.repository.CartRepository;
import com.chicken.de.demo.repository.ProductRepository;
import com.chicken.de.demo.service.interf.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final CartRepository cartRepository;

    @Override
    public Cart addToCart(Product product, int quantity) {
        Optional<Product> productOptional = productRepository.findById(product.getId());
        if (productOptional.isPresent()) {
        Cart cart = new Cart();
            cart.setProductName(product.getName());
            cart.setProductId(product.getId());
            cart.getQuantity();
            return cartRepository.save(cart);
        } else {
            Cart emptyCart = new Cart();
            emptyCart.setQuantity(0);
            return emptyCart;
        }
    }

    @Override
    public Cart removeFromCart(Long productId){
        Optional<Cart> cartOptional = cartRepository.findById(productId);
        if (cartOptional.isPresent()){
            cartOptional.get();
            CartRepository.
        }
    }

}
