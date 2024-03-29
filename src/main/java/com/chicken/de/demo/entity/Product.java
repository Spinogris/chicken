package com.chicken.de.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "products")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "image")
    private String image;

    @Column(name = "name")
    private String name;

    @Column(name = "article")
    private String article;

    @Column(name = "price")
    private double price;

    @Column(name = "price_kg")
    private double priceKg;

}
