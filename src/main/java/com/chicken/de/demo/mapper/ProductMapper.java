package com.chicken.de.demo.mapper;

import com.chicken.de.demo.DTO.product.ProductCreateRequestDTO;
import com.chicken.de.demo.DTO.product.ProductResponseDTO;
import com.chicken.de.demo.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductResponseDTO toDTO(Product product);

    Product toEntity(ProductCreateRequestDTO productCreateRequestDTO);

    List<ProductResponseDTO> allToDTO(List<Product> products);

}
