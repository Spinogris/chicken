package com.chicken.service.interf;

import com.chicken.entity.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    Product getProdById(Long id);

    List<Product> getAllProducts();

    Product removeProductById(Long id);

    List<Product> searchProductsByAll(String article);
}
