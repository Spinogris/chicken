package com.chicken.de.demo.service.interf;

import com.chicken.de.demo.entity.Product;
import org.hibernate.mapping.List;

public interface ProductService {

    Product getProdById(String id);

    List getAllProducts();
}
