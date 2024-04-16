package com.chicken.de.demo.mapper;

import com.chicken.de.demo.DTO.CartDTO;
import com.chicken.de.demo.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    CartDTO toDTO(Cart cart);
}
