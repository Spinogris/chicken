package com.chicken.de.demo.mapper;

import com.chicken.de.demo.DTO.product.ProductCreateRequestDTO;
import com.chicken.de.demo.DTO.product.ProductResponseDTO;
import com.chicken.de.demo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Mapping(source = "descriptions", target = "descriptions")
    ProductResponseDTO toDTO(Product product);

    Product toEntity(ProductCreateRequestDTO productCreateRequestDTO);

    List<ProductResponseDTO> allToDTO(List<Product> products);

}
