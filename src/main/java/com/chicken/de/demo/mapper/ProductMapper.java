package com.chicken.de.demo.mapper;

import com.chicken.de.demo.DTO.ProductDTO;
import com.chicken.de.demo.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductDTO toDTO(Product product);

    List<ProductDTO> allToDTO(List<Product> products);
}
