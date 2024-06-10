package com.chicken.de.demo.DTO.product;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;

@Data
public class ProductCreateRequestDTO {
    private String image;

    @NotBlank
    @Size(min = 5, max = 20)
    private String name;

    @NonNull
    private String article;
    
    @NonNull
    @Size(min = 4, max = 200)
    private String descriptions;

    @NonNull
    @Positive
    private BigDecimal priceForUnit;

    @NonNull
    @Positive
    private BigDecimal priceKg;
}
