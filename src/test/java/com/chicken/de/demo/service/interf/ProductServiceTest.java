package com.chicken.de.demo.service.interf;

import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.repository.ProductRepository;
import com.chicken.de.demo.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    @InjectMocks
    private ProductService productService;
    @Mock
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

        productRepository.save(product);

        Product saveProduct = productService.saveProduct(product);

        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);

        Mockito.verify(productRepository, Mockito.times(1)).save(product);

        assertEquals(img, saveProduct.getImage());
        assertEquals(name, saveProduct.getName());
        assertEquals(article, saveProduct.getArticle());
        assertEquals(priceUnit, saveProduct.getPriceForUnit());
        assertEquals(priceKg, saveProduct.getPriceKg());
    }

    @Test
    void testGetProdById() {

    }

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