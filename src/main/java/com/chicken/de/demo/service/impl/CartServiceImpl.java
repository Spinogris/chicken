package com.chicken.de.demo.service.impl;

import com.chicken.de.demo.DTO.product.ProductResponseDTO;
import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.entity.cart.Cart;
import com.chicken.de.demo.entity.cart.CartItems;
import com.chicken.de.demo.mapper.ProductMapper;
import com.chicken.de.demo.repository.CartRepository;
import com.chicken.de.demo.repository.ProductRepository;
import com.chicken.de.demo.service.interf.CartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    private final ProductMapper productMapper;

    public CartServiceImpl(ProductRepository productRepository,
                           CartRepository cartRepository,
                           ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.productMapper = productMapper;
    }

    @Override
    @Transactional
    public Cart addToCart(Long cart_id, Long product_id, int quantity) {
        Cart cart = cartRepository.findById(cart_id)
                .orElseThrow(() -> new NoSuchElementException("Cart with id " + cart_id + " not found"));
        Product product = productRepository.findById(product_id)
                .orElseThrow(() -> new NoSuchElementException("Cart with id " + cart_id + " not found"));
        Optional<CartItems> existItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(product_id))
                .findFirst();
        if (existItem.isPresent()) {
            CartItems items = existItem.get();
            items.setQuantity(items.getQuantity() + quantity);
        } else {
            CartItems newItems = new CartItems();
            newItems.setCart(cart);
            newItems.setProduct(product);
            newItems.setQuantity(quantity);
            cart.getItems().add(newItems);
        }
        return cartRepository.save(cart);
    }

    @Override
    public Cart removeFromCart(Long cart_id, Long product_id, int quantity) {
        Cart cart = cartRepository.findById(cart_id)
                .orElseThrow(() -> new NoSuchElementException("Cart with id " + cart_id + " not found"));
        productRepository.findById(product_id)
                .orElseThrow(() -> new NoSuchElementException("Cart with id " + product_id + " not found"));
        Optional<CartItems> cartItems = cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(product_id))
                .findFirst();
        if (cartItems.isPresent()) {
            CartItems items = cartItems.get();
            int remainingQuantity = items.getQuantity() - quantity;
            if (remainingQuantity <= 0){
                cart.getItems().remove(cartItems);
            }else {
                items.setQuantity(remainingQuantity);
            }
        } else {
            throw new NoSuchElementException("Product with id " + product_id + " not found in the cart");
        }
        return cartRepository.save(cart);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productMapper.allToDTO(productList);
    }

}
