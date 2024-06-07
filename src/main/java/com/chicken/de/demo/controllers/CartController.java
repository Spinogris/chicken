package com.chicken.de.demo.controllers;

import com.chicken.de.demo.DTO.product.ProductResponseDTO;
import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.entity.cart.Cart;
import com.chicken.de.demo.service.interf.CartService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chicken/cart")
public class CartController {

    private final CartService cartService;

    @Operation(summary = "Добавление продукта в корзину", description = "Доступно авторизованным пользователям")
    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody Long cartId, @RequestParam Long productId, @RequestParam int quantity) {
        cartService.addToCart(cartId, productId, quantity);
        return ResponseEntity.ok("Product added to cart!");
    }

    @Operation(summary = "Удаление из корзины", description = "Доступно авторизованным пользователям")
    @DeleteMapping("/delete")
    public ResponseEntity<Cart> removeFromCart(@RequestParam Long cartId, @RequestParam Long productId, @RequestParam int quantity) {
        try {
            Cart updatedCart = cartService.removeFromCart(cartId, productId, quantity);
            return ResponseEntity.ok(updatedCart);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Просмотр всех продуктов в корзине", description = "Доступно Аутентифицированных пользователей")
    @GetMapping("/getProductsOfCart")
    public List<ProductResponseDTO> getProductsOfCart(){
        return cartService.getAllProducts();
    }
}
