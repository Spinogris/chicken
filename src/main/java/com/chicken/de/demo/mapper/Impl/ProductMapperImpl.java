package com.chicken.de.demo.mapper.Impl;

import com.chicken.de.demo.DTO.product.ProductCreateRequestDTO;
import com.chicken.de.demo.DTO.product.ProductResponseDTO;
import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductResponseDTO toDTO(Product product) {
        ProductResponseDTO productDTO = new ProductResponseDTO();
        productDTO.setId(product.getId());
        productDTO.setImage(product.getImage());
        productDTO.setName(product.getName());
        productDTO.setArticle(product.getArticle());
        productDTO.setDescriptions(productDTO.getDescriptions());
        productDTO.setPriceForUnit(product.getPriceForUnit());
        productDTO.setPriceKg(product.getPriceKg());
        return productDTO;
    }

    @Override
    public Product toEntity(ProductCreateRequestDTO productCreateRequestDTO) {
        Product product = new Product();
        product.setImage(productCreateRequestDTO.getImage());
        product.setName(productCreateRequestDTO.getName());
        product.setArticle(productCreateRequestDTO.getArticle());
        product.setDescriptions(productCreateRequestDTO.getDescriptions());
        product.setPriceForUnit(productCreateRequestDTO.getPriceForUnit());
        product.setPriceKg(productCreateRequestDTO.getPriceKg());
        return product;
    }

    @Override
    public List<ProductResponseDTO> allToDTO(List<Product> products) {
        List<ProductResponseDTO> productDTOS = new ArrayList<>();
        for (Product product : products){
            productDTOS.add(toDTO(product));
        }
        return productDTOS;
    }

}
