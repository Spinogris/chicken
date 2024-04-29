package com.chicken.de.demo.controllers;

import com.chicken.de.demo.DTO.ProductDTO;
import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.mapper.ProductMapper;
import com.chicken.de.demo.service.interf.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chicken/products")
@AllArgsConstructor
public class ProductController {


    private  ProductService productService;

    @GetMapping("/{id}")
    public ProductDTO getProdById(@PathVariable Long id){
        Product prodById = productService.getProdById(id);
        return ProductMapper.INSTANCE.toDTO(prodById);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Product> removeProductById(@PathVariable Long id){
        Product remProdById = productService.removeProductById(id);
        return new ResponseEntity<>(remProdById, HttpStatus.OK);
    }

    @PostMapping ("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product saveProduct = productService.saveProduct(product);
        return ResponseEntity.ok(saveProduct);
    }

    @GetMapping("/search") // http://localhost:8080/chicken/products/search?search=ЗАПРОС
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String search){
        List<Product> products = productService.searchProductsByAll(search);
        return ResponseEntity.ok(products);
    }
}
