package com.chicken.mapper;

import com.chicken.entity.Product;
import com.chicken.DTO.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductDTO toDTO(Product product);

    List<ProductDTO> allToDTO(List<Product> products);

}
