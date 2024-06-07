package com.chicken.de.demo.entity;

import com.chicken.de.demo.entity.cart.CartItems;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Data
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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "article", nullable = false)
    private String article;

    @Column(name = "price", nullable = false)
    private BigDecimal priceForUnit;

    @Column(name = "price_kg")
    private BigDecimal priceKg;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CartItems> cartItems;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id)
                && Objects.equals(image, product.image)
                && Objects.equals(name, product.name)
                && Objects.equals(article, product.article)
                && Objects.equals(priceForUnit, product.priceForUnit)
                && Objects.equals(priceKg, product.priceKg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, image, name, article, priceForUnit, priceKg);
    }
}
