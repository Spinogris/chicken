package com.chicken.de.demo.service.interf;

import com.chicken.de.demo.DTO.product.ProductCreateRequestDTO;
import com.chicken.de.demo.DTO.product.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO saveProduct(ProductCreateRequestDTO product);

    ProductResponseDTO getProdById(Long id);

    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO removeProductById(Long id);

    List<ProductResponseDTO> searchProductsByAll(String article);
}
