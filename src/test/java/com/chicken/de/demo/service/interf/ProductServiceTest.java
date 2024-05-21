package com.chicken.de.demo.service.interf;

import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.repository.ProductRepository;
import com.chicken.de.demo.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    Long id = 1L;
    String img = "Sum-thing Image";
    String name = "Som-thing Name";
    String article = "LoL404";
    BigDecimal priceUnit = BigDecimal.valueOf(12.6);
    BigDecimal priceKg = BigDecimal.valueOf(4.6);


    @Test
    void testSaveProduct() {
        Product product = new Product();
        product.setImage(img);
        product.setName(name);
        product.setArticle(article);
        product.setPriceForUnit(priceUnit);
        product.setPriceKg(priceKg);

        Product saveProduct = productService.saveProduct(product);

        assertNotNull(saveProduct.getId());
        assertTrue(productService.getAllProducts()
                .stream()
                .map(myProduct -> myProduct.getId())
                .collect(Collectors.toSet())
                .contains(saveProduct.getId()));
    }


//    @Test
//    void testGetProdById() {

//    }

    @Test
    void testGetAllProducts() {
    }

    @Test
    void testRemoveProductById() {
    }

    @Test
    void testSearchProductsByAll() {
    }
}