package com.chicken.de.demo.DTO.product;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class ProductResponseDTO {
    private Long id;
    private String image;
    private String name;
    private String article;
    private BigDecimal priceForUnit;
    private BigDecimal priceKg;

}
