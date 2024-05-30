package com.chicken.de.demo.controllers;

import com.chicken.de.demo.DTO.product.ProductDTO;
import com.chicken.de.demo.entity.Cart;
import com.chicken.de.demo.service.interf.CartService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chicken/cart")
public class CartController {

    private CartService cartService;

    @Operation(summary = "Добавление продукта в корзину", description = "Доступно авторизованным пользователям")
    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody ProductDTO product, @RequestBody int quantity) {
        Cart addToCart = cartService.addToCart(product, quantity);
        return new ResponseEntity<>(addToCart, HttpStatus.OK);
    }

    @Operation(summary = "Удаление из корзины", description = "Доступно авторизованным пользователям")
    @DeleteMapping("/delete")
    public ResponseEntity<Cart> removeFromCart(@PathVariable ProductDTO product, @RequestParam int quantity) {
        Cart remFromCart = cartService.removeFromCart(product, quantity);
        return ResponseEntity.ok(remFromCart);
    }
}
