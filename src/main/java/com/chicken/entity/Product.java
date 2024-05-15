package com.chicken.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image")
    private String image;

    @Column(name = "name")
    private String name;

    @Column(name = "article")
    private String article;

    @Column(name = "price")
    private BigDecimal priceForUnit;

    @Column(name = "price_kg")
    private BigDecimal priceKg;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(image, product.image) && Objects.equals(name, product.name) && Objects.equals(article, product.article) && Objects.equals(priceForUnit, product.priceForUnit) && Objects.equals(priceKg, product.priceKg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, image, name, article, priceForUnit, priceKg);
    }
}
