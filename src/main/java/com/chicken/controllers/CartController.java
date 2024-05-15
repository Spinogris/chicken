package com.chicken.controllers;

import com.chicken.entity.Cart;
import com.chicken.DTO.ProductDTO;
import com.chicken.service.interf.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chicken/cart")
public class CartController {

    private  CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody ProductDTO product, @RequestBody int quantity){
        Cart addToCart = cartService.addToCart(product, quantity);
        return new ResponseEntity<>(addToCart, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Cart> removeFromCart(@PathVariable ProductDTO product, @RequestParam int quantity){
        Cart remFromCart = cartService.removeFromCart(product, quantity);
        return ResponseEntity.ok(remFromCart);
    }
}
