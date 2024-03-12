package com.chicken.de.demo.repository;

import com.chicken.de.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getProductById(Long id);

}