package com.chicken.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartDTO {
    private Long id;
    private List<Long> productId = new ArrayList<>();
    private String productName;
    private int quantity;

}
