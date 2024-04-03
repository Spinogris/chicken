package com.chicken.de.demo.controllers;

import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.service.impl.ProductServiceImpl;
import com.chicken.de.demo.service.interf.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chicken/products")
public class ProductController {


    private final ProductService productService;


    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = (List<Product>) productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProdById(@PathVariable Long id){
        Product prodById = productService.getProdById(id);
        return new ResponseEntity<>(prodById, HttpStatus.OK);
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

    @GetMapping("/search")
    public ResponseEntity<Product> searchProductByArticle(@RequestParam String article){
        Product searchProdByArticle = productService.searchProductByArticle(article);
        return new ResponseEntity<>(searchProdByArticle, HttpStatus.OK);
    }
}
