package com.chicken.controllers;

import com.chicken.entity.Product;
import com.chicken.mapper.ProductMapper;
import com.chicken.service.interf.ProductService;
import com.chicken.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public String removeProductById(@PathVariable Long id) {
        Product remProdById = productService.removeProductById(id);
        productMapper.toDTO(remProdById);
        return "Продукт c id " + id + " удалён!";
    }

    @PostMapping("/save")
    public String saveProduct(@RequestBody Product product) {
        Product saveProduct = productService.saveProduct(product);
        ResponseEntity.ok(saveProduct);
        return "Продукт c id " + product.getId() + product.getName() + " добавлен!";
    }

    @GetMapping("/search") // http://localhost:8080/chicken/products/search?search=ЗАПРОС
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String search) {
        List<Product> products = productService.searchProductsByAll(search);
        return ResponseEntity.ok(products);
    }

    public ProductController(ProductService productService,
                             ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }
}
