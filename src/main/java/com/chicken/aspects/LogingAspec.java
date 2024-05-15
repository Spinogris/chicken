package com.chicken.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogingAspec {

    @Before("execution(public * com.chicken.service.interf.ProductService.saveProduct(com.chicken.entity.Product))")
    public void beforeSaveProduct(){

    }
}
