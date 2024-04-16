package com.chicken.de.demo.config;

import com.chicken.de.demo.mapper.AccountMapper;
import com.chicken.de.demo.mapper.CartMapper;
import com.chicken.de.demo.mapper.ProductMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public AccountMapper accountMapper() {
        return AccountMapper.INSTANCE;
    }
    @Bean
    public ProductMapper productMapper(){
        return ProductMapper.INSTANCE;
    }
    @Bean
    public CartMapper cartMapper(){
        return CartMapper.INSTANCE;
    }
}
