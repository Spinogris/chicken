package com.chicken.de.demo.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Cart {
    private List<Product> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItem(String productName) {
        items.removeIf(product -> product.getName().equals(productName));
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : items) {
            totalPrice += product.getPrice() * product.getQuantity();
        }
        return totalPrice;
    }
}