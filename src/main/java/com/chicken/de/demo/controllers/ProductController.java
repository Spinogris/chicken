package com.chicken.de.demo.controllers;

import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.service.interf.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("index")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/chicken/{id}")
    public Product getProductById(@PathVariable("id") String id){
        return productService.getProdById(id);
    }

//    @GetMapping("/chicken")
//    public String chicken(Model model) {
//        Iterable<Product> products = productRepository.findAll();
//        model.addAttribute("chicken", products);
//        return "/chicken";
//    }
//    @GetMapping("/innereien")
//    public String innereien(Model model) {
//        Iterable<Product> products = productRepository.findAll();
//        model.addAttribute("innereien", products);
//        return "/innereien";
//    }
//    @GetMapping("/semifinished")
//    public String semifinished(Model model) {
//        Iterable<Product> products = productRepository.findAll();
//        model.addAttribute("semifinished", products);
//        return "/semifinished";
//    }
//    @GetMapping("/teilen")
//    public String teilen(Model model) {
//        Iterable<Product> products = productRepository.findAll();
//        model.addAttribute("teilen", products);
//        return "/teilen";
//    }
//    @GetMapping("/wurst")
//    public String wurst(Model model) {
//        Iterable<Product> products = productRepository.findAll();
//        model.addAttribute("wurst", products);
//        return "/wurst";
//    }

}