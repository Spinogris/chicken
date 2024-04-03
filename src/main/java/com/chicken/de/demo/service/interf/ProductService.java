package com.chicken.de.demo.service.interf;

import com.chicken.de.demo.entity.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    Product getProdById(Long id);

    List<Product> getAllProducts();

    Product removeProductById(Long id);

    Product searchProductByArticle(String article);
}
