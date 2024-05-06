package com.chicken.de.demo.controllers;

import com.chicken.de.demo.DTO.ProductDTO;
import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.mapper.ProductMapper;
import com.chicken.de.demo.service.interf.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chicken/products")
public class ProductController {

    @Autowired
    private final ProductService productService;
    @Autowired
    private final ProductMapper productMapper;



    @GetMapping("/{id}")
    public ProductDTO getProdById(@PathVariable Long id) {
        Product prodById = productService.getProdById(id);
        return productMapper.toDTO(prodById);
    }

    @GetMapping("/all")
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return productMapper.allToDTO(products);
    }

    @DeleteMapping("/{id}")
    public ProductDTO removeProductById(@PathVariable Long id) {
        Product remProdById = productService.removeProductById(id);
        return productMapper.toDTO(remProdById);
    }

    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product saveProduct = productService.saveProduct(product);
        return ResponseEntity.ok(saveProduct);
    }

    @GetMapping("/search") // http://localhost:8080/chicken/products/search?search=ЗАПРОС
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String search) {
        List<Product> products = productService.searchProductsByAll(search);
        return ResponseEntity.ok(products);
    }

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }
}
