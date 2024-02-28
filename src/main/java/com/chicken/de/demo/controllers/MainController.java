package com.chicken.de.demo.controllers;

import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private ProductRepository productRepository;

    @Autowired
    public MainController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/home")
    public String home(Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("product", products);
        return "home";
    }

}