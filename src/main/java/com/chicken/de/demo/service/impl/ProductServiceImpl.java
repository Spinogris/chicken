package com.chicken.de.demo.service.impl;


import com.chicken.de.demo.DTO.product.ProductCreateRequestDTO;
import com.chicken.de.demo.DTO.product.ProductResponseDTO;
import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.mapper.ProductMapper;
import com.chicken.de.demo.repository.ProductRepository;
import com.chicken.de.demo.service.interf.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    @Transactional
    public ProductResponseDTO saveProduct(ProductCreateRequestDTO productDTO) {
        return productMapper.toDTO(productRepository.save(productMapper.toEntity(productDTO)));
    }

    @Override
    public ProductResponseDTO getProdById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));
        return productMapper.toDTO(product);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return productMapper.allToDTO(productRepository.findAll());
    }

@Override
@Transactional
public ProductResponseDTO removeProductById(Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product with id " + id + " not found"));
    productRepository.deleteById(id);
    return null;
}


    @Override
    public List<ProductResponseDTO> searchProductsByAll(String search) {
        List<Product> productList = productRepository.searchProductsByAll(search);
        return productMapper.allToDTO(productList);
    }

}
