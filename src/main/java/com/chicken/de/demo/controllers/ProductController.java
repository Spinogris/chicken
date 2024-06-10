package com.chicken.de.demo.controllers;

import com.chicken.de.demo.DTO.product.ProductCreateRequestDTO;
import com.chicken.de.demo.DTO.product.ProductResponseDTO;
import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.service.interf.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chicken/products")
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Сохраняет продукт. Id автогенерируется",
            description = "Доступно MANAGER, ADMIN <br>В 'image' ссылка на изображение")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
//    @PreAuthorize("permitAll()")
    @PostMapping("/create")
    public ProductResponseDTO createProduct(@Valid @RequestBody ProductCreateRequestDTO product) {
        return productService.saveProduct(product);
    }

    @Operation(summary = "Список продукта по id", description = "Доступно MANAGER, ADMIN")
    @GetMapping("/{id}")
    public ProductResponseDTO getProdById(@PathVariable Long id) {
        return productService.getProdById(id);
    }

    @Operation(summary = "Список всех продуктов", description = "Доступно всем")
    @GetMapping("/all")
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @Operation(summary = "Удаление продукта по id", description = "Доступно для ADMIN, MANAGER")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
//    @PreAuthorize("permitAll()")
    @DeleteMapping("/delete/{id}")
    public String removeProductById(@PathVariable Long id) {
        String product = productService.getProdById(id).getName();
        productService.removeProductById(id);
        return "Продукт c id " + id + " name '" + product + "' удалён!";
    }

    @Operation(summary = "Поиск продукта по name, article",
            description = "Доступно для USER. http://localhost:8080/chicken/products/search?search=ЗАПРОС")
    @GetMapping("/search") // http://localhost:8080/chicken/products/search?search=ЗАПРОС
    public List<ProductResponseDTO> searchProducts(@RequestParam String search) {
        return productService.searchProductsByAll(search);
    }
}
