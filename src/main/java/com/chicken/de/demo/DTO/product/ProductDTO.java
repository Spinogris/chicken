package com.chicken.de.demo.DTO.product;

import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;


@Data
public class ProductDTO {
    public Long id;
    public String image;
    public String name;
    public String article;
    private String descriptions;
    public BigDecimal priceForUnit;
    public BigDecimal priceKg;

    public ProductDTO() {

    }
}
