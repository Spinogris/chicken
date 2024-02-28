package com.chicken.de.demo.repository;

import com.chicken.de.demo.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ProductRepository extends CrudRepository<Product, Long> {
}
