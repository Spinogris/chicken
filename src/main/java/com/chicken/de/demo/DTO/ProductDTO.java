package com.chicken.de.demo.DTO;

import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;


@Data
public class ProductDTO {
    public Long id;
    public String image;
    public String name;
    public String article;
    public BigDecimal priceForUnit;
    public BigDecimal priceKg;

    public ProductDTO() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setPriceForUnit(BigDecimal priceForUnit) {
        this.priceForUnit = priceForUnit;
    }

    public void setPriceKg(BigDecimal priceKg) {
        this.priceKg = priceKg;
    }

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


    public ProductDTO(Long id, String image, String name, String article, BigDecimal priceForUnit, BigDecimal priceKg) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.article = article;
        this.priceForUnit = priceForUnit;
        this.priceKg = priceKg;
    }


}
