package com.chicken.de.demo.controllers;

import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.service.interf.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("index")
public class ProductController {

    private final ProductService productService;


    @GetMapping("/chicken/product/{id}")
    public Product getProductById(@PathVariable("id") String id){
        return productService.getProdById(id);
    }


}