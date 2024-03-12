package com.chicken.de.demo.service.impl;


import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.repository.ProductRepository;
import com.chicken.de.demo.service.interf.ProductService;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product getProdById(String id) {

        return productRepository.getProductById(Long.valueOf(id));
    }

    @Override
    public List getAllProducts() {
        return null;
    }
}
