package com.chicken.de.demo.mapper.Impl;

import com.chicken.de.demo.DTO.ProductDTO;
import com.chicken.de.demo.entity.Product;
import com.chicken.de.demo.mapper.ProductMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setImage(product.getImage());
        productDTO.setName(product.getName());
        productDTO.setArticle(product.getArticle());
        productDTO.setPriceForUnit(product.getPriceForUnit());
        productDTO.setPriceKg(product.getPriceKg());
        return productDTO;
    }

    @Override
    public List<ProductDTO> allToDTO(List<Product> products) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products){
            productDTOS.add(toDTO(product));
        }
        return productDTOS;
    }

}
