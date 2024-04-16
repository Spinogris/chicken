package com.chicken.de.demo.repository;

import com.chicken.de.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    Product findByArticle(String article);
}