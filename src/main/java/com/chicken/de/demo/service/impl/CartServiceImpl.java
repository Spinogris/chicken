package com.chicken.de.demo.service.impl;

import com.chicken.de.demo.DTO.ProductDTO;
import com.chicken.de.demo.entity.Cart;
import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.repository.CartRepository;
import com.chicken.de.demo.repository.ProductRepository;
import com.chicken.de.demo.service.interf.CartService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    @Override
    public Cart addToCart(ProductDTO product, int quantity) {
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
    public Cart removeFromCart(ProductDTO product, int quantity) {
        Optional<Cart> cartOptional = cartRepository.findById(product.getId());
        if (cartOptional.isPresent()) {
            cartOptional.get();
            cartRepository.deleteById(product.getId());
        } else {
            System.out.println("Product not available!");
        }
        return null;
    }

    public CartServiceImpl(ProductRepository productRepository,
                           CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }
}
