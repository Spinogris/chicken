package com.chicken.de.demo.service.impl;


import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.mapper.ProductMapper;
import com.chicken.de.demo.repository.ProductRepository;
import com.chicken.de.demo.service.interf.ProductService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Data
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final ProductMapper productMapper;
    @PersistenceContext
    private final EntityManager entityManager;


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
    public Product removeProductById(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            productRepository.deleteById(id);
            return optionalProduct.get();
        } else {
            throw new NoSuchElementException("Product with id " + id + " not found");
        }
    }

    @Override
    public List<Product> searchProductsByAll(String search) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> productRoot = criteriaQuery.from(Product.class);
        List<Predicate> predicates = new ArrayList<>();
        if (search != null) {
            String searchPattern = "%" + search.toLowerCase() + "%";
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(productRoot.get("name")), searchPattern));
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(productRoot.get("article")), searchPattern));
        }
        criteriaQuery.where(criteriaBuilder.or(predicates.toArray(new Predicate[0])));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, EntityManager entityManager) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.entityManager = entityManager;
    }

}
