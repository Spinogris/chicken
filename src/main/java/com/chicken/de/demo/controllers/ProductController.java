package com.chicken.de.demo.controllers;

import com.chicken.de.demo.DTO.product.ProductCreateRequestDTO;
import com.chicken.de.demo.DTO.product.ProductResponseDTO;
import com.chicken.de.demo.mapper.ProductMapper;
import com.chicken.de.demo.service.interf.ProductService;
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
    @PreAuthorize("hasRole('ROLE_ADMIN, ROLE_MANAGER')")
    @PostMapping("/save")
    public ProductResponseDTO saveProduct(@Valid @RequestBody ProductCreateRequestDTO product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProdById(@PathVariable Long id) {
        return productService.getProdById(id);
    }

    @GetMapping("/all")
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN, ROLE_MANAGER')")
    @DeleteMapping("/{id}")
    public String removeProductById(@PathVariable Long id) {
        productService.removeProductById(id);
        return "Продукт c id " + id + productService.getProdById(id).getName() + " удалён!";
    }


    @GetMapping("/search") // http://localhost:8080/chicken/products/search?search=ЗАПРОС
    public List<ProductResponseDTO> searchProducts(@RequestParam String search) {
        return productService.searchProductsByAll(search);
    }
}
