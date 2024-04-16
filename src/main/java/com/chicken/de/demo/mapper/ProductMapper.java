package com.chicken.de.demo.mapper;

import com.chicken.de.demo.DTO.ProductDTO;
import com.chicken.de.demo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toDTO(Product product);
}
