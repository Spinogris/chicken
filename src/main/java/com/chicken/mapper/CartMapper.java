package com.chicken.mapper;

import com.chicken.DTO.CartDTO;
import com.chicken.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    CartDTO toDTO(Cart cart);
}
