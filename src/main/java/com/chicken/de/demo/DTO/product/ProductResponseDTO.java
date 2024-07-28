package com.chicken.de.demo.DTO.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ProductResponseDTO {
    private Long id;
    private String image;
    private String name;
    private String article;
    private String descriptions;
    private BigDecimal priceForUnit;
    private BigDecimal priceKg;

}
