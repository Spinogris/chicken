package com.chicken.de.demo.service.impl;


import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.repository.ProductRepository;
import com.chicken.de.demo.service.interf.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public Product getProdById(Long id) {
        return productRepository.getReferenceById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product removeProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productOptional.get();
            productRepository.deleteById(id);
        } else {
            System.out.println("Product not available.");
        }
        return null;
    }

    @Override
    public Product searchProductByArticle(String article) {
        return (Product) productRepository.findAll();
    }


}
