package com.chicken.de.demo.DTO;

import lombok.Value;

import java.math.BigDecimal;


@Value
public class ProductDTO {
    public Long id;
    public String image;
    public String name;
    public String article;
    public BigDecimal priceForUnit;
    public BigDecimal priceKg;
    public int quantity;

    public Long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getArticle() {
        return article;
    }

    public BigDecimal getPriceForUnit() {
        return priceForUnit;
    }

    public BigDecimal getPriceKg() {
        return priceKg;
    }

    public int getQuantity() {
        return quantity;
    }

}
